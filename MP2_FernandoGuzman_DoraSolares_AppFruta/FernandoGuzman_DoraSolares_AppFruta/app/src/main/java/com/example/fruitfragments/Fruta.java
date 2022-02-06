package com.example.fruitfragments;

public class Fruta {

    //atributos
    public String nombre;
    public String color;
    public String sabor;
    public double peso;
    public String descripcion;
    public int imagenFrutaID;

    public Fruta(String n, String c, String s, double p, String d, int img) {
        nombre = n;
        color = c;
        sabor = s;
        peso = p;
        descripcion = d;
        imagenFrutaID = img;
    }

    //getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagenFrutaID() {
        return imagenFrutaID;
    }

    public void setImagenFrutaID(int imagenFrutaID) {
        this.imagenFrutaID = imagenFrutaID;
    }
}
