package com.example.analy.administrador;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.analy.administrador.tablas.AulaLaboratorio;
import com.example.analy.administrador.tablas.Derivado;
import com.example.analy.administrador.tablas.Estado;
import com.example.analy.administrador.tablas.Grado;
import com.example.analy.administrador.tablas.TipoDeEquipo;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MenuPrincipal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Session session;
    Button gen_btn;
    EditText txtdescripcion;
    ImageView image;
    EditText txtnroaula;
    //SPINNER
     public  static String idclie;
    Button btnguardar;
    Spinner spgrados,sptipoequipos,spaula,spestado1,spderivado;


    List<TipoDeEquipo> lista2;
    List<AulaLaboratorio>lista3;
    List<Grado> lista;
    List<Estado>lista4;
    List<Derivado>lista5;
    String grados,tipo,aulalaboratorio,estado,derivado;

    public static String idcliente;
    public static final String id="id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        final Bundle recupera=getIntent().getExtras();

        if (recupera != null) {
            idcliente = recupera.getString(id);
        }


        Toast.makeText(this, ""+idcliente, Toast.LENGTH_SHORT).show();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        sptipoequipos=(Spinner)findViewById(R.id.sptipoequipos);
        lista2 = new ArrayList<TipoDeEquipo>();
        lista2.add(new TipoDeEquipo("1","PC"));
        lista2.add(new TipoDeEquipo("2","Proyector"));
        lista2.add(new TipoDeEquipo("3","CPU"));
        lista2.add(new TipoDeEquipo("4","Equipo de sonido"));

        ArrayAdapter<TipoDeEquipo> arrayAdapter2 = new ArrayAdapter<TipoDeEquipo>(this, android.R.layout.simple_list_item_1, lista2 );
        sptipoequipos.setAdapter(arrayAdapter2);

        sptipoequipos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                TipoDeEquipo selectedItem = lista2.get(position);


                // cantidad= new String(selectedItem.getDescripcion());
                tipo=selectedItem.getIdestado();



                //  Toast.makeText(getApplicationContext(), ""+tipomovimiento, Toast.LENGTH_LONG).show();
            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

        spaula=(Spinner)findViewById(R.id.spaula);
        lista3 = new ArrayList<AulaLaboratorio>();
        lista3.add(new AulaLaboratorio("1","Aula"));
        lista3.add(new AulaLaboratorio("2","Laboratorio"));


        ArrayAdapter<AulaLaboratorio> arrayAdapter3 = new ArrayAdapter<AulaLaboratorio>(this, android.R.layout.simple_list_item_1, lista3 );
        spaula.setAdapter(arrayAdapter3);

        spaula.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                AulaLaboratorio selectedItem = lista3.get(position);


                // cantidad= new String(selectedItem.getDescripcion());
                aulalaboratorio=selectedItem.getIdaulla();
                Log.i("aula",aulalaboratorio);



                //  Toast.makeText(getApplicationContext(), ""+tipomovimiento, Toast.LENGTH_LONG).show();
            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

        spgrados=(Spinner)findViewById(R.id.spgrados);
        lista = new ArrayList<Grado>();
        lista.add(new Grado("1","Emergencia"));
        lista.add(new Grado("2","Normal"));
        lista.add(new Grado("3","Urgente"));
        lista.add(new Grado("4","Derivado"));

        ArrayAdapter<Grado> arrayAdapter = new ArrayAdapter<Grado>(this, android.R.layout.simple_list_item_1, lista );
        spgrados.setAdapter(arrayAdapter);

        spgrados.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                Grado selectedItem = lista.get(position);


                // cantidad= new String(selectedItem.getDescripcion());
                grados=selectedItem.getIdestado();
                // editText3.setText(grados);
                //  Toast.makeText(getApplicationContext(), ""+tipomovimiento, Toast.LENGTH_LONG).show();
            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
        ////

        spestado1=(Spinner)findViewById(R.id.spestado1);
        lista4 = new ArrayList<Estado>();

        lista4.add(new Estado("1","Derivado"));
       lista4.add(new Estado("2","Resuelto"));
        lista4.add(new Estado("3","Pendiente"));

        ArrayAdapter<Estado> arrayAdapter5 = new ArrayAdapter<Estado>(this, android.R.layout.simple_list_item_1, lista4 );
        spestado1.setAdapter(arrayAdapter5);

        spestado1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                Estado selectedItem = lista4.get(position);


                // cantidad= new String(selectedItem.getDescripcion());
                estado=selectedItem.getIdestado();




                //  Toast.makeText(getApplicationContext(), ""+tipomovimiento, Toast.LENGTH_LONG).show();
            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

        spderivado=(Spinner)findViewById(R.id.spderivado);
        lista5 = new ArrayList<Derivado>();

        lista5.add(new Derivado("1","Asistente"));
        lista5.add(new Derivado("2","Mantenimiento"));


        ArrayAdapter<Derivado> arrayAdapter6 = new ArrayAdapter<Derivado>(this, android.R.layout.simple_list_item_1, lista5 );
        spderivado.setAdapter(arrayAdapter6);

        spderivado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                Derivado selectedItem = lista5.get(position);


                // cantidad= new String(selectedItem.getDescripcion());
                derivado=selectedItem.getIdDerivado();




                //  Toast.makeText(getApplicationContext(), ""+tipomovimiento, Toast.LENGTH_LONG).show();
            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });




        txtnroaula=(EditText)findViewById(R.id.txtnroaula) ;
        btnguardar=(Button)findViewById(R.id.btnguardar);
        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread tr2 = new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        RegistrarPost(idcliente,grados,tipo,aulalaboratorio,derivado,estado,txtnroaula.getText().toString());
                        //RegistrarPost("1","2","3","1","1","2","2");

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), " registro exitoso", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(getApplicationContext(),MenuPrincipal.class);
                                startActivity(i);
                            }
                        });
                    }
                };
                tr2.start();
            }
        });




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        txtdescripcion=(EditText)findViewById(R.id.txtdescripcion);
        image=(ImageView)findViewById(R.id.image);
        gen_btn=(Button)findViewById(R.id.gen_btn);
        gen_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try{
                    BitMatrix bitMatrix= multiFormatWriter.encode("text2Qr", BarcodeFormat.QR_CODE,200,200);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    image.setImageBitmap(bitmap);
                }catch (WriterException e){
                    e.printStackTrace();
                }
            }
        });











    }
    public static String getIdclientes() {

        idclie= idcliente;
        return idclie;
    }
    public void RegistrarPost( String Admin_idadmin, String Grado_idgrado, String TipoDeEquipo_idtipoequipo,String AulaLaboratorio_idaulla,
                               String Derivado_idderivado,String Estado_idestado,String nroaula){

        String urlParameters="&Admin_idadmin="+Admin_idadmin+
                "&Grado_idgrado="+ Grado_idgrado+"&TipoDeEquipo_idtipoequipo="+TipoDeEquipo_idtipoequipo+
                "&AulaLaboratorio_idaulla="+AulaLaboratorio_idaulla+"&Derivado_idderivado="+Derivado_idderivado+
                "&Estado_idestado="+Estado_idestado+"&nroaula="+nroaula;
        HttpURLConnection conection=null;
        try {

            URL url = new URL("http://www.capacitasoft.com/site/Prueba/Admin/registrarProblema.php?");
            conection = (HttpURLConnection) url.openConnection();

            //estableciendo el metodo
            conection.setRequestMethod("POST");
            //longitud de datos que se envian
            conection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));

            //comando para la salida de datos
            conection.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(conection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.close();

            InputStream is = conection.getInputStream();
        } catch (Exception ex){ }
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent i = new Intent(getApplicationContext(),MenuPrincipal.class);
            startActivity(i);
        } else if (id == R.id.nav_gallery) {
            Intent i = new Intent(getApplicationContext(),MostrarRegistroEquipo.class);
            startActivity(i);

        }  else if (id == R.id.nav_share) {
            Intent i = new Intent(getApplicationContext(),MostrarRegistroProblemaEquipos.class);
            startActivity(i);
        } else if (id == R.id.cerrarsesion) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("¿Desea salir de la App?");
            builder.setTitle("Alerta!");
            builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    cerrandoSesion();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void cerrandoSesion(){
        session = new Session(this);
        if(!session.loggedin()){
            logout();
        }
        logout();
    }
    private void logout(){
        session.setLoggedin(false);
        finish();
        startActivity(new Intent(MenuPrincipal.this,MainActivity.class));
    }
}
