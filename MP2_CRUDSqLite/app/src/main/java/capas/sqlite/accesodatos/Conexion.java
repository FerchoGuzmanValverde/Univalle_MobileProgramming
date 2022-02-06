package capas.sqlite.accesodatos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Conexion extends SQLiteOpenHelper {
    private final String LOGCAT = "AVISO:";
    private final String query="CREATE TABLE (Producto) ((idProducto) INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, (nombre) VARCHAR(50) NOT NULL, (descripcion) VARCHAR(80) NOT NULL, (precio) FLOAT NOT NULL, (fechaVencimiento) DATE NOT NULL);";

    public Conexion(Context aplicationContext){
        super(aplicationContext, "DBPractica.s3db", null, 1);
        Log.d(LOGCAT,"Created");
    }

    @Override
    public void onCreate(SQLiteDatabase database){
        database.execSQL(query);
        Log.d(LOGCAT, "Productos");
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int i, int i1) {
        String queryTable =  "";
        queryTable = "DROP TABLE IF EXISTS Producto;";
        database.execSQL(queryTable);
        onCreate(database);
    }

    public void ejecutarComando(String sql){
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL(sql);
        Log.d(LOGCAT, "Sentencia Ejecutada");
    }

    public Cursor ejecutarQuery(String sql){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(sql, null);
        return  cursor;
    }

}
