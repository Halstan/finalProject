package com.example.finalproject.Clases;

public class Ventas {

    private String idVenta;
    private String idUsuario;
    private String producto;
    private String precio;
    private String cantidad;
    private String fecha;
    private String importePagar;

    public Ventas() {
    }

    public Ventas(String idVenta, String idUsuario, String producto, String precio, String cantidad, String fecha, String importePagar) {
        this.idVenta = idVenta;
        this.idUsuario = idUsuario;
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.importePagar = importePagar;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getImportePagar() {
        return importePagar;
    }

    public void setImportePagar(String importePagar) {
        this.importePagar = importePagar;
    }
}
