package com.example.fruitfragments;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FrutasAdapter extends ArrayAdapter {
    public Activity context;
    public ArrayList<Fruta> datos;

    public FrutasAdapter(Fragment context, ArrayList<Fruta> datos) {
        super(context.getActivity(), R.layout.item_fruta, datos);

        this.context = context.getActivity();
        this.datos = datos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.item_fruta, null);

        ImageView imagen = (ImageView) item.findViewById(R.id.imgFruta);
        imagen.setImageResource(datos.get(position).getImagenFrutaID());

        TextView sabor = (TextView) item.findViewById(R.id.tvContent);
        sabor.setText(datos.get(position).getSabor());

        TextView nombre = (TextView) item.findViewById(R.id.tvField);
        nombre.setText(datos.get(position).getNombre());

        return item;
    }
}
