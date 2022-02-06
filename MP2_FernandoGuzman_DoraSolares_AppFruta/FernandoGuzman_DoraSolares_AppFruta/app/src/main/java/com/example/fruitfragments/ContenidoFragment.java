package com.example.fruitfragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContenidoFragment extends Fragment {

    TextView _textViewContenido;
    ImageView _imageViewFruta;

    public ContenidoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contenido, container, false);
        // Inflate the layout for this fragment
        _textViewContenido=view.findViewById(R.id.textViewDescripcion);
        _imageViewFruta = view.findViewById(R.id.imageViewFruta);
        return view;
    }

    public void renderText(Fruta frutita){
        _textViewContenido.setText("Nombre: " + frutita.nombre + "\nColor: " + frutita.color + "\nSabor: " + frutita.sabor + "\nPeso: " + frutita.peso + "\nDescripcion: " + frutita.descripcion);
        _imageViewFruta.setImageResource(frutita.imagenFrutaID);
    }



}
