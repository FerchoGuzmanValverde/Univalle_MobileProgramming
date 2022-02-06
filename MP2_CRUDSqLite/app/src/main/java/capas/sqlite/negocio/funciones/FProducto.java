package capas.sqlite.negocio.funciones;

import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

import capas.sqlite.accesodatos.Conexion;
import capas.sqlite.negocio.clases.Producto;

public class FProducto {

    public static Producto get (String pnombre, Conexion con) throws Exception{
        Producto miProducto = null;
        try {
            String sql = "SELECT idProducto, nombre, descripcion, precio, fechaVencimiento FROM Prodcuto WHERE nombre = "+ pnombre;
            Cursor cursor = con.ejecutarQuery(sql);
            if (cursor.moveToFirst()){
                do {
                    Date fecha = new Date(cursor.getLong(4));
                    miProducto = new Producto(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getFloat(3), fecha);
                } while (cursor.moveToNext());
                Log.d("Error", "Recuperado");
            }
        } catch (Exception ex){
            throw ex;
        }
        return miProducto;
    }

    public static List<Producto> getAll(Conexion con) throws Exception{
        ArrayList<Producto> lstProducto = new ArrayList<Producto>();
        try{
           String sql = "SELECT idProducto, nombre, descripcion, precio, fechaVencimiento FROM Producto";
           Cursor cursor = con.ejecutarQuery(sql);
           lstProducto = llenarProductos(cursor);
        }catch (Exception ex){
            throw ex;
        }
        return lstProducto;
    }

    private static ArrayList<Producto> llenarProductos(Cursor cursor) throws Exception{
        ArrayList<Producto> lst = new ArrayList<Producto>();
        try{
            if (cursor.moveToFirst()){
                do{
                    Date fecha = new Date(cursor.getLong(4));
                    lst.add(new Producto(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getFloat(3), fecha));
                }
                while (cursor.moveToNext());
                Log.d("Aviso", "Recuperado: " + lst.size());
            }
        }catch (Exception ex){
            throw ex;
        }
        return lst;
    }
}
