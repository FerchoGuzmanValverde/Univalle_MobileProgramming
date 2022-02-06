package com.example.javi.contrato.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.javi.contrato.data.ContratoMascota.MascotaEntry;

/**
 * Created by JAvi on 18/04/2018.
 */

public class MascotaHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "Mascota.db";
    private static final int DATABASE_VERSION = 1;

    public MascotaHelper(Context context){

        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }


    //Autoimplementar:
    //onCreate cuando la bd se crea por primera vez
    @Override
    public void onCreate(SQLiteDatabase db) {
    //crear la tabla mascota
    //se debe importar el contrato import com.example.javi.contrato.data.ContratoMascota;

        String SQL_CREATE_MASCOTA_TABLE =
                "CREATE TABLE "+ MascotaEntry.TABLE_NAME + " ("
                + MascotaEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + MascotaEntry.COLUMN_MASCOTA_NOMBRE+" TEXT NOT NULL, "
                + MascotaEntry.COLUMN_MASCOTA_RAZA+" TEXT, "
                + MascotaEntry.COLUMN_MASCOTA_GENERO+" INTEGER NOT NULL, "
                + MascotaEntry.COLUMN_MASCOTA_PESO+" INTEGER NOT NULL DEFAULT 0);" ;
    //Metodo para ejecutar una consulta:
        db.execSQL(SQL_CREATE_MASCOTA_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
