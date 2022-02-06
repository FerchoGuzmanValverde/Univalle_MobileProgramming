package capas.sqlite.negocio.clases;

import java.util.Date;

public class Producto {
    private int idProducto;
    private String nombreProducto;
    private String descripcion;
    private float precio;
    private Date fechaVencimiento;

    public Producto(){

    }

    public Producto(String nombreProducto, String descripcion, float precio, Date fechaVencimiento) {
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Producto(int idProducto, String nombreProducto, String descripcion, float precio, Date fechaVencimiento) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}
