package com.example.listados;

import android.content.Context;
import android.sax.Element;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MiAdapter extends ArrayAdapter {

    Context context;
    int itemLayout;
    ArrayList<Elemento> datos;

    public MiAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Elemento> objects) {
        super(context, resource, objects);
        this.context = context;
        itemLayout = resource;
        datos = objects;

    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(itemLayout, parent, false);
        }

        TextView textoTV = convertView.findViewById(R.id.textoTV);
        textoTV.setText(datos.get(position).texto);

        ImageView imagenIV = convertView.findViewById(R.id.imagenIV);
        imagenIV.setImageResource(datos.get(position).imagen);

        ImageView imagenIV1 = convertView.findViewById(R.id.imagenIV1);
        imagenIV1.setImageResource(datos.get(position).imagen1);

        return convertView;

    }
}
