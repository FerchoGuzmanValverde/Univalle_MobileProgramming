package com.example.javi.contrato.data;

import android.provider.BaseColumns;

/**
 * Created by JAvi on 18/04/2018.
 */

public final class ContratoMascota {
    //privado para prevenir instanciar accidentalmente
    private ContratoMascota(){}

    public static final class MascotaEntry implements BaseColumns{

        public static final String TABLE_NAME = "gato";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_MASCOTA_NOMBRE="nombre";
        public static final String COLUMN_MASCOTA_RAZA="raza";
        public static final String COLUMN_MASCOTA_GENERO="genero";
        public static final String COLUMN_MASCOTA_PESO="peso";

        public static final int GENERO_DESCONOCIDO = 0;
        public static final int GENERO_MACHO = 1;
        public static final int GENERO_HEMBRA = 2;

    }
}
