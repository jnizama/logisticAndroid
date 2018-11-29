package com.example.ronald.logistica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ronald.data.entities.OrdenCompra;

public class Main9Activity extends AppCompatActivity {

    OrdenCompra myOrdenCompra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        myOrdenCompra = (OrdenCompra) getIntent().getSerializableExtra("MyCompra"); //Obtiene de nuevo la compra para concluiar si grabacion.
        setvalueOrdenCompra(myOrdenCompra);

    }
    public void setvalueOrdenCompra(OrdenCompra ordenCompra)
    {
        TextView txtnumOrden = (TextView) findViewById(R.id.txtnumOrden);
        TextView txtProveedor = (TextView) findViewById(R.id.txtProveedor);
        TextView txtDescripcion = (TextView) findViewById(R.id.txtDescripcion);
        TextView txtCantidad = (TextView) findViewById(R.id.txtCantidad);
        TextView txtPrecioUnitario = (TextView) findViewById(R.id.txtPrecioUnitario);
        TextView txtPrecioTotal = (TextView) findViewById(R.id.txtPrecioTotal);

        txtnumOrden.setText(ordenCompra.getNumeroOrden());
        txtProveedor.setText(ordenCompra.getProveedor());
        txtDescripcion.setText(ordenCompra.getDescripcion());
        String cant = String.valueOf(ordenCompra.getCantidad());
        txtCantidad.setText(cant);
        String precUnitario = String.valueOf(ordenCompra.getPreciounitario());
        String precTotal = String.valueOf(ordenCompra.getPreciototal());
        txtPrecioUnitario.setText(precUnitario);
        txtPrecioTotal.setText(precTotal);
    }
    public void onCancelar(View view)
    {
        this.onBackPressed();
    }

}
