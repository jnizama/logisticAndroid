package com.example.ronald.logistica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonCancelar:
                launchCompra();
                break;
            case R.id.buttonGuardar:
                launchInventario();
                break;
            case R.id.buttonAlmacen:
                launchAlmacen();
                break;
            case R.id.buttonOrdenCompra:
                launchOrdenCompra();
                break;
        }

    }

    private void launchCompra() {
        Intent nextActivity = new Intent(this, Main3Activity.class);
        startActivity(nextActivity);
    }
    private void launchInventario() {
        Intent nextActivity = new Intent(this, Main5Activity.class);
        startActivity(nextActivity);
    }
    private void launchAlmacen() {
        Intent nextActivity = new Intent(this, Main10Activity.class);
        startActivity(nextActivity);
    }
    private void launchOrdenCompra() {
        Intent nextActivity = new Intent(this, Main8Activity.class);
        startActivity(nextActivity);
    }
}
