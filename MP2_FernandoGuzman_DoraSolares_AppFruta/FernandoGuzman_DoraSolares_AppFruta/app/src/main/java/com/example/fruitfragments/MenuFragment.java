package com.example.fruitfragments;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment implements AdapterView.OnItemClickListener {

    public ArrayList<Fruta> frutas;
    public ListView listView;
    private DataListener _callback;
    public MenuFragment(){
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        frutas=new ArrayList<Fruta>();
        rellenarArrayList();
        listView = view.findViewById(R.id.listViewFrutas1);
        FrutasAdapter adapter;
        adapter = new FrutasAdapter(this, frutas);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        return view;
    }

    public void rellenarArrayList(){
        frutas.add(new Fruta("Papaya", "Naranja", "Dulce", 1.0,"Grande", R.drawable.papaya));
        frutas.add(new Fruta("Frutilla", "Rojo", "Dulce", 0.2,"Pequeña", R.drawable.frutilla));
        frutas.add(new Fruta("Banana", "Amarillo", "Dulce", 0.5,"Mediana", R.drawable.banana));
        frutas.add(new Fruta("Piña", "Amarillo", "Acida", 1.2,"Grande", R.drawable.pi_a));
        frutas.add(new Fruta("Chirimoya", "Verde", "Dulce", 0.8,"Mediana", R.drawable.chirimoya));
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        try{
            _callback=(DataListener)context;
        }catch(Exception ex){
            throw new ClassCastException(context.toString()+"Deberia implementar un DataListener");
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapter, View view, int position, long ID) {

        _callback.sendData(frutas.get(position));
    }



}


