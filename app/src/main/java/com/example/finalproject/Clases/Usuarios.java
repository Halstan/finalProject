package com.example.finalproject.Clases;

public class Usuarios {

    private String idUsuario;
    private String mail;
    private String password;
    private String nombre;
    private String apellido;
    private String edad;

    public Usuarios() {
    }

    public Usuarios(String idUsuario, String mail, String password, String nombre, String apellido, String edad) {
        this.idUsuario = idUsuario;
        this.mail = mail;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
}
