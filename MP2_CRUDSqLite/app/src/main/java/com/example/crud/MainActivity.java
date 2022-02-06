package com.example.crud;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import capas.sqlite.accesodatos.Conexion;
import capas.sqlite.negocio.clases.Producto;
import capas.sqlite.negocio.funciones.FProducto;

public class MainActivity extends AppCompatActivity {

    public ListView lstDatos;
    public EditText nombre;
    public Button btnBuscar;
    ArrayAdapter<Producto> adaptProducto;
    Conexion conexion = new Conexion(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lstDatos = findViewById(R.id.lstDatos);
        nombre = findViewById(R.id.txtNombre);
        btnBuscar = findViewById(R.id.btnBuscar);
        CargarProductos();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.itemCrear) {
            Intent nuevo = new Intent(this, Insertar.class);
            startActivity(nuevo);
        }
        else if (id == R.id.itemModificar){

        }
        else{

        }
        return super.onOptionsItemSelected(item);
    }

    public void CargarProductos(){
        try{
            List<Producto> lstProductos = FProducto.getAll(conexion);
            System.out.println("Productos Recuperados");
            adaptProducto = new ArrayAdapter<Producto>(this, android.R.layout.simple_list_item_1, lstProductos);
            lstDatos.setAdapter(adaptProducto);

        }catch (Exception ex){
            Log.d("Error", ex.getMessage());
        }
    }

    @Override
    public void onResume (){
        super.onResume();
        CargarProductos();
    }

}
