package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;

import capas.sqlite.accesodatos.Conexion;
import capas.sqlite.negocio.clases.Producto;
import capas.sqlite.negocio.funciones.FProducto;

public class Insertar extends AppCompatActivity {

    public EditText nombreInsertar;
    public EditText descripcionInsertar;
    public EditText precioInsertar;
    public CalendarView fechaInsertar;

    public Button guardar;
    public Button cancelar;

    Conexion conexion = new Conexion(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);

        nombreInsertar = findViewById(R.id.txtNombreInsert);
        descripcionInsertar = findViewById(R.id.txtDescripcion);
        precioInsertar = findViewById(R.id.txtPrecio);
        fechaInsertar = findViewById(R.id.dateFechaVencimiento);

        guardar = findViewById(R.id.btnInsertar);
        cancelar = findViewById(R.id.btnCancelar);


    }

    public void btnGuadar(View view)
    {
        Date fecha  = new Date(fechaInsertar.getDate());
        Producto prod = new Producto(nombreInsertar.getText().toString(),descripcionInsertar.getText().toString(), Float.parseFloat(precioInsertar.getText().toString()), fecha);
        try{
            if ()
        }
    }
}
