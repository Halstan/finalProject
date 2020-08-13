package com.example.finalproject;

import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.finalproject.Clases.SQLDB;

public class RegistrarActivity extends AppCompatActivity {

    EditText edtId, edtNombre, edtMail, edtApellido, edtEdad, edtContrasena;
    Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        Referencias();

        final SQLDB objBD = new SQLDB(getApplicationContext());

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    objBD.insertarUsuario(
                            edtMail.getText().toString(),
                            edtContrasena.getText().toString(),
                            edtNombre.getText().toString(),
                            edtApellido.getText().toString(),
                            edtEdad.getText().toString());
                    Toast.makeText(RegistrarActivity.this, "Usuario a sido registrado correctamente", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);

                }catch (SQLiteException ex){
                    Toast.makeText(RegistrarActivity.this, "Error al registrar", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void Referencias() {
        edtId = findViewById(R.id.txtIdUsuario);
        edtNombre = findViewById(R.id.txtNombre);
        edtApellido = findViewById(R.id.txtApellido);
        edtEdad = findViewById(R.id.txtEdad);
        edtMail = findViewById(R.id.txtCorreo);
        edtContrasena = findViewById(R.id.txtContraseña);
        btnRegistrar = findViewById(R.id.btnRegistrar);
    }

    public void visualizar(View view) {
        Intent mostrarUsuarios = new Intent(getApplicationContext(), ListaUsuarios.class);
        startActivity(mostrarUsuarios);
    }


}