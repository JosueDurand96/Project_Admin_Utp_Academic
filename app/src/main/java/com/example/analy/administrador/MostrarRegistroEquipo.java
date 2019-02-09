package com.example.analy.administrador;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.analy.administrador.adapter.ResumenListViewAdapter;
import com.example.analy.administrador.tablas.Incidencias;
import com.example.analy.administrador.tablas.tabla1;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MostrarRegistroEquipo extends AppCompatActivity {
    ListView lstresumen;
    ImageView imageView14;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_registro_equipo);
        lstresumen=(ListView)findViewById(R.id.lstresumen);
        imageView14=(ImageView)findViewById(R.id.imageView14);
        imageView14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        listar();
    }

    public void listar() {
        TareaWSListar tarea = new TareaWSListar();
        tarea.execute();
    }
    String getVariableBolean = MenuPrincipal.getIdclientes();

    //Tarea Asíncrona para llamar al WS de listado en segundo plano
    public class TareaWSListar extends AsyncTask<String,Integer,Boolean> {

        public List<tabla1> listaCategoria;

        protected Boolean doInBackground(String... params) {

            HttpURLConnection connection = null;
            BufferedReader reader = null;
            boolean resul = true;
            String urlApiREST = "http://www.capacitasoft.com/site/Prueba/Admin/listaProblemaEquipo.php?&idadmin="+getVariableBolean;
            try {
                URL url = new URL(urlApiREST);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String line ="";
                while ((line = reader.readLine()) != null){
                    buffer.append(line);
                }
                String finalJson = buffer.toString();
                JSONObject parentObject = new JSONObject(finalJson);
                JSONArray parentArray = parentObject.getJSONArray("lista");
                listaCategoria = new ArrayList<tabla1>();
                for(int i=0; i<parentArray.length(); i++) {
                    JSONObject finalObject = parentArray.getJSONObject(i);
                    String  Descrip_tipo = finalObject.getString("Descrip_tipo");
                    String Auladescripcion = finalObject.getString("Auladescripcion");
                    String nroaula = finalObject.getString("nroaula");


                    listaCategoria.add(new tabla1(Descrip_tipo,Auladescripcion,nroaula));
                }
            } catch(Exception ex) {
                Log.e("ServicioRest","Error!", ex);
                resul = false;
            }
            return resul;


        }


        protected void onPostExecute(Boolean result) {


            if (result) {

                //Rellenamos la lista con los nombres de los productos
                //Rellenamos la lista con los resultados
                ResumenListViewAdapter adaptador = new ResumenListViewAdapter(MostrarRegistroEquipo.this, listaCategoria);
                lstresumen.setAdapter(adaptador);
                lstresumen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        tabla1 elegido = (tabla1) parent.getItemAtPosition(position);

                        CharSequence texto = "Seleccionado: " + elegido.getDescrip_tipo();



                        // final  String idddd = elegido.idcategoria;
                    }
                });

            }
        }


    }
}
