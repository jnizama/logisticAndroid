package com.example.ronald.logistica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
    }
    public void onConsultarxCodigo(View view)
    {
        launchConsultarxCodigo();
    }
    public void onStock(View view)
    {
        launchonStock();
    }
    private void launchConsultarxCodigo() {
        Intent nextActivity = new Intent(this, Main6Activity.class);
        startActivity(nextActivity);
    }
    private void launchonStock() {
        Intent nextActivity = new Intent(this, Main7Activity.class);
        startActivity(nextActivity);
    }
    public void onCancelar(View view)
    {
        this.onBackPressed();
    }
}
