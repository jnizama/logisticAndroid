package com.example.ronald.logistica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main10Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
    }

    public void onCancelar(View view)
    {
        this.onBackPressed();
    }

    public void onIngreso(View view)
    {
        Intent nextActivity = new Intent(this, Main11Activity.class);
        startActivity(nextActivity);
    }
    public void onSalida(View view)
    {
        Intent nextActivity = new Intent(this, Main12Activity.class);
        startActivity(nextActivity);
    }
}
