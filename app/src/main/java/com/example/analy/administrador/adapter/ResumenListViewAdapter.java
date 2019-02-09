package com.example.analy.administrador.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.analy.administrador.R;
import com.example.analy.administrador.tablas.Incidencias;
import com.example.analy.administrador.tablas.tabla1;


import java.util.List;

public class ResumenListViewAdapter extends BaseAdapter {
    LayoutInflater inflater;
    List<tabla1> items;
    private Context mContext;

    public ResumenListViewAdapter(Activity context, List<tabla1> items) {
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
            convertView = inflater.inflate(R.layout.mostrar_registro_equipo, null);

//        ImageView imgThumbnail = (ImageView)convertView.findViewById(R.id.imageViewImagen);
        TextView txtgrado = (TextView)convertView.findViewById(R.id.txtgrado);

        TextView txtaula = (TextView)convertView.findViewById(R.id.txtaula);
        TextView txtnroaula = (TextView)convertView.findViewById(R.id.txtnroaula);
//        ImageView btnmapaagencia = (ImageView)convertView.findViewById(R.id.btnmapaagencia);
//
//
//
            txtgrado.setText(item.Descrip_tipo);

        txtaula.setText(item.Auladescripcion);
        txtnroaula.setText(item.nroaula);

        //final int latitud = Integer.parseInt(String.valueOf((item.latitud)));
        //  final int longitud = Integer.parseInt(String.valueOf((item.longitud)));


        return convertView;
    }
}
