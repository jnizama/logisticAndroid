package com.example.ronald.logistica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ronald.data.DataCompras;
import com.example.ronald.data.DataDetalleCompras;
import com.example.ronald.data.entities.Compra;
import com.example.ronald.data.entities.DetalleCompra;
import com.example.ronald.helper.Utils;

import java.net.Inet4Address;

public class Main4Activity extends AppCompatActivity {
    private Compra myCompra;
    private DataDetalleCompras dataDetalleCompras;
    private DataCompras dataCompras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        myCompra = (Compra) getIntent().getSerializableExtra("MyCompra"); //Obtiene de nuevo la compra para concluiar si grabacion.
        dataCompras = new DataCompras(this);
        dataDetalleCompras = new DataDetalleCompras(this);

        final TextView txtCantidad = (TextView) findViewById(R.id.txtCantidad);
        final TextView txtPrecioUnitario = (TextView) findViewById(R.id.txtPrecioUnitario);
        final TextView txtPrecioTotal = (TextView) findViewById(R.id.txtPrecioTotal);

        txtCantidad.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try{
                    int cant = Integer.valueOf(txtCantidad.getText().toString());
                    double preciounit = Double.valueOf(txtPrecioUnitario.getText().toString());
                    double t = cant * preciounit;
                    txtPrecioTotal.setText(String.valueOf(t));
                }
                catch (Exception e)
                {
                    txtPrecioTotal.setText("0.00");
                }
            }
        });

        txtPrecioUnitario.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try{
                    int cant = Integer.valueOf(txtCantidad.getText().toString());
                    double preciounit = Double.valueOf(txtPrecioUnitario.getText().toString());
                    double t = cant * preciounit;
                    txtPrecioTotal.setText(String.valueOf(t));
                }
                catch (Exception e)
                {
                    txtPrecioTotal.setText("0.00");
                }
            }
        });


    }
    private String validarIngresoDatos() {
        String msgReturn = "";

        TextView txtcodigoItem = (TextView) findViewById(R.id.txtcodigoItem);
        TextView txtDescripcion = (TextView) findViewById(R.id.txtDescripcion);
        TextView txtCantidad = (TextView) findViewById(R.id.txtCantidad);
        TextView txtPrecioUnit = (TextView) findViewById(R.id.txtPrecioUnitario);
        TextView txtPrecioTotal = (TextView) findViewById(R.id.txtPrecioTotal);

        if (txtcodigoItem.getText().toString().trim().length() == 0)
            return "Debe ingresar código de item";
        if (txtDescripcion.getText().toString().trim().length() == 0)
            return "Debe ingresar descripcion ";
        if (txtCantidad.getText().toString().trim().length() == 0)
            return "Debe ingresar cantidad";
        if (txtPrecioUnit.getText().toString().trim().length() == 0)
            return "Debe ingresar precio unitario";
        if (txtPrecioTotal.getText().toString().trim().length() == 0)
            return "Debe ingresar precio total";


        return "";
    }

    public void onGrabar(View view)
    {
        String msg = validarIngresoDatos();
        if (msg != "")
        {
            Utils.ShowMessage(this,"Validación" ,msg);
            return;
        }

        TextView txtcodigoItem = (TextView) findViewById(R.id.txtcodigoItem);
        TextView txtDescripcion = (TextView) findViewById(R.id.txtDescripcion);
        TextView txtCantidad = (TextView) findViewById(R.id.txtCantidad);
        TextView txtPrecioUnit = (TextView) findViewById(R.id.txtPrecioUnitario);
        TextView txtPrecioTotal = (TextView) findViewById(R.id.txtPrecioTotal);

        Integer Cant = Integer.valueOf(txtCantidad.getText().toString());
        Double PrecioUnit = Double.valueOf(txtPrecioUnit.getText().toString());
        Double Total = Double.valueOf(txtPrecioTotal.getText().toString());

        myCompra.setDetalles(new DetalleCompra(txtcodigoItem.getText().toString(), txtDescripcion.getText().toString(),Cant, PrecioUnit, Total));

        try
        {
            //Guardar en base de datos la Compra y mostrar imagen de transaccion conforme.
            dataCompras.Insert(myCompra);
            dataDetalleCompras.Insert(myCompra.getDetalles());

            Utils.ShowMessage(this,"Compra","Se ha registrado su compra de forma satisfactoria");
            Toast.makeText(getApplicationContext(), "Grabación de la compra correctamente ;)", Toast.LENGTH_LONG).show();
            Button btnDetalleRequerimiento = (Button) findViewById(R.id.btnDetalleRequerimiento);
            btnDetalleRequerimiento.setEnabled(false);

        }
        catch (Exception ex) {
            Utils.ShowMessage(this,"Error al grabar la compra",ex.getMessage());
        }
    }

}
