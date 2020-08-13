package com.example.finalproject;

import com.example.finalproject.Clases.Ventas;
import org.junit.Assert;
import org.junit.Test;

public class VentasTest {

    private Ventas ventas;

    void Test(){
        ventas = new Ventas();
    }

    @Test
    public void testImportePagar() {
        Test();
        ventas.setImportePagar("39.98");
        Assert.assertEquals("39.98", ventas.getImportePagar());
    }

    @Test
    public void testCantidadBad(){
        Test();
        ventas.setCantidad("3");
        Assert.assertEquals("5", ventas.getCantidad());
    }

    @Test
    public void testCantidadGood(){
        Test();
        ventas.setCantidad("2");
        Assert.assertEquals("2", ventas.getCantidad());
    }

    @Test
    public void testPrecioBad(){
        Test();
        ventas.setPrecio("19.99");
        Assert.assertEquals("14", ventas.getPrecio());
    }

    @Test
    public void testPrecioGood(){
        Test();
        ventas.setPrecio("19.99");
        Assert.assertEquals("19.99", ventas.getPrecio());
    }

}