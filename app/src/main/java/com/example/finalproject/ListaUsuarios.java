package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.Adaptadores.AdaptadorUsuarios;
import com.example.finalproject.Clases.SQLDB;

public class ListaUsuarios extends AppCompatActivity {

    RecyclerView recyclerViewUsuarios;
    AdaptadorUsuarios adaptadorUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);

        recyclerViewUsuarios = findViewById( R.id.recycleViewUsuarios);
        recyclerViewUsuarios.setLayoutManager( new LinearLayoutManager( this ) );

        SQLDB sqlBD = new SQLDB(getApplicationContext());
        adaptadorUsuarios = new AdaptadorUsuarios(sqlBD.visualizarUsuarios());

        recyclerViewUsuarios.setAdapter(adaptadorUsuarios);
    }
}