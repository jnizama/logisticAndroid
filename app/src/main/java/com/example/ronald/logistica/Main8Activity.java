package com.example.ronald.logistica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ronald.data.DataOrdenCompras;
import com.example.ronald.data.entities.OrdenCompra;
import com.example.ronald.helper.Utils;

public class Main8Activity extends AppCompatActivity {

    private DataOrdenCompras dataOrdenCompras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        dataOrdenCompras = new DataOrdenCompras(this);
    }

    public void onCancelar(View view)
    {
        this.onBackPressed();
    }
    public void onConsultar(View view)
    {
        this.launchConsultar();
    }
    private void launchConsultar() {

        TextView txtnumOrden = (TextView) findViewById(R.id.txtnumOrden);
        TextView txtnumRuc = (TextView) findViewById(R.id.txtnumRuc);

        if(txtnumOrden.getText().length() == 0 && txtnumRuc.getText().length() == 0)
        {
            Utils.ShowMessage(this,"Orden Compra","De ingresar número de orden de compra ó Ruc");
            return;
        }
        String numOrden = txtnumOrden.getText().toString();
        String ruc = txtnumRuc.getText().toString();

        OrdenCompra ordenCompra = dataOrdenCompras.Buscar(numOrden, ruc);
        Intent nextActivity = new Intent(this, Main9Activity.class);
        nextActivity.putExtra("MyCompra", ordenCompra);
        startActivity(nextActivity);
    }

}
