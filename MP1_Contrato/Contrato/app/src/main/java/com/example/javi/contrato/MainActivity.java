package com.example.javi.contrato;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.javi.contrato.data.ContratoMascota;
import com.example.javi.contrato.data.ContratoMascota.MascotaEntry;
import com.example.javi.contrato.data.MascotaHelper;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MascotaHelper mDbHelper;
    //crear elementos del activity
    private EditText nombre;
    private EditText raza;
    private EditText peso;
    private Spinner genero;


    /**
     *
     * {@link MascotaEntry#GENERO_DESCONOCIDO}, {@link MascotaEntry#GENERO_MACHO}, or
     * {@link MascotaEntry#GENERO_HEMBRA}.
     */
    private int mGender = MascotaEntry.GENERO_DESCONOCIDO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbHelper=new MascotaHelper(this);

        //Encontrar views relevantes:
        nombre=findViewById(R.id.etNombre);
        raza=findViewById(R.id.etRaza);
        peso=findViewById(R.id.etPeso);
        genero=findViewById(R.id.spGenero);
        setupSpinner();

    }

    private void setupSpinner() {
        //antes de hacer esto hay que crear EL ARRAY Y LOS STRING

        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter genderSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_gender_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        genderSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        genero.setAdapter(genderSpinnerAdapter);

        // Set the integer mSelected to the constant values
        genero.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.gender_male))) {
                        mGender = MascotaEntry.GENERO_MACHO;
                    } else if (selection.equals(getString(R.string.gender_female))) {
                        mGender = MascotaEntry.GENERO_HEMBRA;
                    } else {
                        mGender = MascotaEntry.GENERO_DESCONOCIDO;
                    }
                }
            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mGender = MascotaEntry.GENERO_DESCONOCIDO;
            }
        });
    }

    public void datosPrueba(View v) {


        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(MascotaEntry.COLUMN_MASCOTA_NOMBRE, "Nombre Generico");
        values.put(MascotaEntry.COLUMN_MASCOTA_RAZA, "Sin asignar");
        values.put(MascotaEntry.COLUMN_MASCOTA_GENERO, MascotaEntry.GENERO_MACHO);
        values.put(MascotaEntry.COLUMN_MASCOTA_PESO, 0);


            long newRowId=db.insert(MascotaEntry.TABLE_NAME,null,values);



       displayDatabaseInfo();

    }


    public void insertarMascota(View v) {

            String nombreString = nombre.getText().toString().trim();
            String razaString=raza.getText().toString().trim();
            String pesoString=peso.getText().toString().trim();
            int pesoInt= Integer.parseInt(pesoString);



            MascotaHelper mDHelper = new MascotaHelper(this);

            //ahora lo demas es igual que los datos de relleno que usamos

            SQLiteDatabase db = mDbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(MascotaEntry.COLUMN_MASCOTA_NOMBRE, nombreString);
            values.put(MascotaEntry.COLUMN_MASCOTA_RAZA, razaString);
            values.put(MascotaEntry.COLUMN_MASCOTA_GENERO, mGender);
            values.put(MascotaEntry.COLUMN_MASCOTA_PESO, pesoInt);

            long newRowId=db.insert(MascotaEntry.TABLE_NAME,null,values);

            //verificar que se inserto corretamente
            if (newRowId==-1 )
            {
                Toast.makeText(this,"Error al guardar mascota",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"Mascota guardada con el id: "+newRowId,Toast.LENGTH_SHORT).show();
            }


    }


    private void displayDatabaseInfo() {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        Cursor cursor;
        cursor = db.rawQuery("SELECT * FROM " + MascotaEntry.TABLE_NAME, null);
        try {
            // Muestra el numero de filas en la tabla de la base de datos
            TextView displayView = (TextView) findViewById(R.id.tvMascota);
            displayView.setText("Numero de filas en la tabla de la BD: " + cursor.getCount());
        } finally {
            Toast.makeText(this,"Error ....",Toast.LENGTH_SHORT).show();
            cursor.close();
        }

    }



}
