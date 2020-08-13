package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.Adaptadores.AdaptadorVentas;
import com.example.finalproject.Clases.SQLDB;

public class ListaVentas extends AppCompatActivity {

    RecyclerView recyclerViewVentas;
    AdaptadorVentas adaptadorVentas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_ventas);

        recyclerViewVentas = findViewById( R.id.recycleViewVentas);
        recyclerViewVentas.setLayoutManager( new LinearLayoutManager( this ) );

        SQLDB sqlBD = new SQLDB(getApplicationContext());
        adaptadorVentas = new AdaptadorVentas(sqlBD.visualizarVentas());

        recyclerViewVentas.setAdapter(adaptadorVentas);
    }
}