package com.example.finalproject.Clases;

public class Elementos {

    private String nombre;
    private String informacion;
    private int imagen;

    public Elementos() {
    }

    public Elementos(String nombre, String informacion, int imagen) {
        this.nombre = nombre;
        this.informacion = informacion;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
