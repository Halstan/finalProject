package com.example.finalproject.Clases;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SQLDB extends SQLiteOpenHelper {

    private static final String NOMBRE_BD = "RikazzoDB";

    private static final int VERSION_BD = 1;

    private static final String TABLA_VENTAS = "CREATE TABLE VENTAS(" +
            "IDVENTA INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "IDUSUARIO INTEGER, " +
            "PRODUCTO TEXT, " +
            "PRECIO DOUBLE, " +
            "CANTIDAD INTEGER, " +
            "FECHA DATE, " +
            "IMPORTEPAGAR DOUBLE)";

    private static final String TABLA_USUARIOS = "CREATE TABLE USUARIOS(" +
            "IDUSUARIO INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "MAIL TEXT," +
            "PASSWORD TEXT, " +
            "NOMBRE TEXT," +
            "APELLIDO TEXT, " +
            "EDAD TEXT)";

    public SQLDB(@Nullable Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_USUARIOS);
        db.execSQL(TABLA_VENTAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion>oldVersion) {
            db.execSQL("DROP TABLE IF EXISTS TABLA_VENTAS");
            db.execSQL("DROP TABLE IF EXISTS TABLA_USUARIOS");
            db.execSQL(TABLA_VENTAS);
            db.execSQL(TABLA_USUARIOS);
        }
    }

    public void insertarVentas(String idUsuario, String producto, String precio, String cantidad, String fecha, String importePagar){
        SQLiteDatabase db = getWritableDatabase();
        if(db!=null){
            db.execSQL("INSERT INTO VENTAS(idUsuario,producto,precio,cantidad,fecha,importePagar) VALUES ('"+idUsuario+"','"+producto+"','"+precio+"','"+cantidad+"','"+fecha+"','"+ importePagar +"')");
            db.close();
        }
    }

    public void updateVentas(String idVenta, String idUsuario, String producto, String precio, String cantidad, String fecha, String importePagar){
        SQLiteDatabase db = getWritableDatabase();
        if(db!=null){
            db.execSQL("UPDATE VENTAS SET IDUSUARIO = '"+idUsuario+"', PRODUCTO = '"+producto+"', PRECIO = '"+precio+"', CANTIDAD = '"+cantidad+"', FECHA = '"+fecha+"', IMPORTEPAGAR = '"+importePagar+"' WHERE IDVENTA = '"+idVenta+"'");
            db.close();
        }
    }

    public void deleteVentas(String idVenta){
        SQLiteDatabase db = getWritableDatabase();
        if(db!=null){
            db.execSQL("DELETE FROM VENTAS WHERE IDVENTA = '"+idVenta+"'");
            db.close();
        }
    }

    public List<Ventas> visualizarVentas(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM VENTAS", null);
        List<Ventas> ventas = new ArrayList<>( );
        if(cursor.moveToFirst()){
            do{
                ventas.add(new Ventas( cursor.getString( 0 ),
                        cursor.getString( 1 ),
                        cursor.getString( 2 ),
                        cursor.getString( 3 ),
                        cursor.getString( 4 ),
                        cursor.getString( 5 ),
                        cursor.getString( 6 )));
            }while(cursor.moveToNext());
        }
        return ventas;
    }

    public void buscarVentas(Ventas ventas, String idVenta){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM VENTAS WHERE IDVENTA = '"+idVenta+"'", null);
        if(cursor.moveToFirst()){
            do{
                ventas.setIdUsuario(cursor.getString(1));
                ventas.setProducto(cursor.getString(2));
                ventas.setPrecio(cursor.getString(3));
                ventas.setCantidad(cursor.getString(4));
                ventas.setFecha(cursor.getString(5));
                ventas.setImportePagar(cursor.getString(6));
            }while(cursor.moveToNext());
        }
    }

    public void insertarUsuario(String mail, String password, String nombre, String apellido, String edad){
        SQLiteDatabase bd = getWritableDatabase();
        if(bd != null){
            bd.execSQL("INSERT INTO USUARIOS(mail,password,nombre,apellido,edad) VALUES ('"+mail+"','"+password+"','"+nombre+"','"+apellido+"','"+edad+"')");
            bd.close();
        }
    }

    public Cursor validarUsuario(String mail, String pass){
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = null;
        cursor = this.getReadableDatabase().query("USUARIOS", new String[] {"idUsuario", "mail", "password", "nombre", "apellido", "edad"}, "mail LIKE '"+mail+"' and password LIKE '"+pass+"'", null, null, null, null );

        return cursor;
    }

    public List<Usuarios> visualizarUsuarios(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM USUARIOS", null);
        List<Usuarios> usuarios = new ArrayList<>( );
        if(cursor.moveToFirst()){
            do{
                usuarios.add(new Usuarios( cursor.getString( 0 ),
                        cursor.getString( 1 ),
                        cursor.getString( 2 ),
                        cursor.getString( 3 ),
                        cursor.getString( 4 ),
                        cursor.getString( 5 )));
            }while(cursor.moveToNext());
        }
        return usuarios;
    }

}
