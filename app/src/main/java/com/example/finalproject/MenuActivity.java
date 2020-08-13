package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void Click(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.Regresar:
                intent = new Intent( MenuActivity.this, LoginActivity.class );
                break;
            case R.id.MenuVenta:
                intent = new Intent( MenuActivity.this, MainActivity.class );
                break;
            case R.id.RikazzoMovil:
                intent = new Intent( MenuActivity.this, RikazzoActivity.class );
                break;
        }
        startActivity( intent );
    }
}
