package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalproject.Clases.SQLDB;
import com.example.finalproject.Clases.Ventas;

public class MainActivity extends AppCompatActivity {

    EditText edtCodigoVenta, edtCodigoUsuario, edtProducto, edtPrecio, edtCantidad, edtFecha, edtImportePagar;
    Button btnAgre, btnEdi, btnEli, btnLim, btnBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        asignarReferencias();

        final SQLDB objDB = new SQLDB(getApplicationContext());

        btnAgre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                objDB.insertarVentas(
                        edtCodigoUsuario.getText().toString(),
                        edtProducto.getText().toString(),
                        edtPrecio.getText().toString(),
                        edtCantidad.getText().toString(),
                        edtFecha.getText().toString(),
                        edtImportePagar.getText().toString());
                Toast.makeText( MainActivity.this, "Venta Insertada Correctamente!", Toast.LENGTH_LONG).show();
            }
        });

        btnEdi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                objDB.updateVentas(edtCodigoVenta.getText().toString(),
                        edtCodigoUsuario.getText().toString(),
                        edtProducto.getText().toString(),
                        edtPrecio.getText().toString(),
                        edtCantidad.getText().toString(),
                        edtFecha.getText().toString(),
                        edtImportePagar.getText().toString());
                Toast.makeText( MainActivity.this, "Venta Actualizada Correctamente!", Toast.LENGTH_LONG).show();
            }
        });

        btnEli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                objDB.deleteVentas(edtCodigoVenta.getText().toString());
                Toast.makeText( MainActivity.this, "Venta Eliminada Correctamente!", Toast.LENGTH_LONG).show();
            }
        });

        btnBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ventas ventas = new Ventas();
                objDB.buscarVentas(ventas, edtCodigoVenta.getText().toString());
                edtCodigoUsuario.setText(ventas.getIdUsuario());
                edtProducto.setText(ventas.getProducto());
                edtPrecio.setText(ventas.getPrecio());
                edtCantidad.setText(ventas.getCantidad());
                edtFecha.setText(ventas.getFecha());
                edtImportePagar.setText(ventas.getImportePagar());
                Toast.makeText( MainActivity.this, "Venta Encontrada Correctamente!", Toast.LENGTH_LONG).show();
            }
        });

        btnLim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtCodigoVenta.setText("");
                edtCodigoUsuario.setText("");
                edtProducto.setText("");
                edtPrecio.setText("");
                edtCantidad.setText("");
                edtFecha.setText("");
                edtImportePagar.setText("");
            }
        });
    }

    private void asignarReferencias() {
        edtCodigoVenta = (EditText) findViewById(R.id.edtCodigoVenta);
        edtCodigoUsuario = (EditText) findViewById(R.id.edtCodigoUsuario);
        edtProducto = (EditText) findViewById(R.id.edtProducto);
        edtPrecio = (EditText) findViewById(R.id.edtPrecio);
        edtCantidad = (EditText) findViewById(R.id.edtCantidad);
        edtFecha = (EditText) findViewById(R.id.edtFecha);
        edtImportePagar = (EditText) findViewById(R.id.edtImportePagar);
        btnAgre = (Button) findViewById(R.id.btnAgregar);
        btnEdi = (Button) findViewById(R.id.btnEditar);
        btnEli = (Button) findViewById(R.id.btnEliminar);
        btnLim = (Button) findViewById(R.id.btnLimpiar);
        btnBus = (Button) findViewById(R.id.btnBuscar);
    }

    public void visualizar(View view) {
        Intent mostrarVentas = new Intent(getApplicationContext(), ListaVentas.class);
        startActivity(mostrarVentas);
    }

    public void Click(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.Regresar:
                intent = new Intent( MainActivity.this, MenuActivity.class );
                break;
        }
        startActivity( intent );
    }
}
