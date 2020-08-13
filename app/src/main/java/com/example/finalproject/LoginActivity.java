package com.example.finalproject;

import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.finalproject.Clases.SQLDB;

public class LoginActivity extends AppCompatActivity {

    EditText edtMail, edtPass;
    Button btnIngresar, btnNewUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        asignarReferencias();

        final SQLDB objBD = new SQLDB(getApplicationContext());

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = objBD.validarUsuario( edtMail.getText().toString(), edtPass.getText().toString());

                if (cursor.getCount() > 0){
                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText( LoginActivity.this, "¡Credenciales incorrectas!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void asignarReferencias() {
        edtMail = (EditText) findViewById(R.id.txtMail);
        edtPass = (EditText) findViewById(R.id.txtContrasena);
        btnIngresar = (Button) findViewById(R.id.btnIniciar);
        btnNewUser = (Button) findViewById(R.id.btnRegistrar);
    }

    public void registrar(View view) {
        Intent intent = new Intent(getApplicationContext(), RegistrarActivity.class);
        startActivity(intent);
    }
}