package com.example.analy.administrador.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.analy.administrador.R;
import com.example.analy.administrador.tablas.tabla1;

import java.util.List;

public class ResumenListViewAdapter2  extends BaseAdapter {
    LayoutInflater inflater;
    List<tabla1> items;
    private Context mContext;

    public ResumenListViewAdapter2(Activity context, List<tabla1> items) {
        super();
        this.mContext = context;
        this.items = items;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final tabla1 item = items.get(position);

        if(convertView==null)
            convertView = inflater.inflate(R.layout.mostrar_list, null);

//        ImageView imgThumbnail = (ImageView)convertView.findViewById(R.id.imageViewImagen);
        TextView txtgrado2 = (TextView)convertView.findViewById(R.id.txtgrado2);

        TextView txtaula2 = (TextView)convertView.findViewById(R.id.txtaula2);
        TextView txtnroaula = (TextView)convertView.findViewById(R.id.txtderivado);
        TextView txtestado = (TextView)convertView.findViewById(R.id.txtestado);

//        ImageView btnmapaagencia = (ImageView)convertView.findViewById(R.id.btnmapaagencia);
//
//
//
     txtgrado2.setText(item.Descrip_tipo);

        txtaula2.setText(item.Auladescripcion);
        txtnroaula.setText(item.derivado_Des);
        txtestado.setText(item.Estado_Des);

        //final int latitud = Integer.parseInt(String.valueOf((item.latitud)));
        //  final int longitud = Integer.parseInt(String.valueOf((item.longitud)));


        return convertView;
    }
}
