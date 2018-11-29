package com.example.ronald.logistica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ronald.data.DataAlmacen;
import com.example.ronald.data.entities.Almacen;
import com.example.ronald.helper.Utils;

public class Main12Activity extends AppCompatActivity {

    DataAlmacen dataAlmacen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);

        dataAlmacen = new DataAlmacen(this);

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
    public void onGuardar(View view) {
        String msg = validarIngresoDatos();
        if (msg != "")
        {
            Utils.ShowMessage(this,"Validación" ,msg);
            return;
        }

        TextView txtFechaSalida = (TextView) findViewById(R.id.txtFechaSalida);
        TextView txtcodigoItem = (TextView) findViewById(R.id.txtcodigoItem);
        TextView txtDescripcion = (TextView) findViewById(R.id.txtDescripcion);
        TextView txtAreaSolicitante = (TextView) findViewById(R.id.txtAreaSolicitante);
        TextView txtentreadoA = (TextView) findViewById(R.id.txtentreadoA);
        TextView txtCantidad = (TextView) findViewById(R.id.txtCantidad);
        TextView txtPrecioUnitario = (TextView) findViewById(R.id.txtPrecioUnitario);
        TextView txtPrecioTotal = (TextView) findViewById(R.id.txtPrecioTotal);


        Almacen myAlmacen = new Almacen();
        myAlmacen.setTipoMovimiento("S"); //I:Ingreso , S: Salida
        myAlmacen.setCodigoitem(txtcodigoItem.getText().toString());
        myAlmacen.setAreasolicitante(txtAreaSolicitante.getText().toString());
        myAlmacen.setDescripcion(txtDescripcion.getText().toString());
        myAlmacen.setFechamovimiento(txtFechaSalida.getText().toString());
        myAlmacen.setEntregadoa(txtentreadoA.getText().toString());
        myAlmacen.setCantidad(txtCantidad.getText().toString());
        myAlmacen.setPreciounitario(txtPrecioUnitario.getText().toString());
        myAlmacen.setPreciototal(txtPrecioTotal.getText().toString());

        try
        {
            //Guardar en base de datos
            dataAlmacen.Insert(myAlmacen);
            Utils.ShowMessage(this,"Inventario","Se ha registrado de forma satisfactoria");
            Toast.makeText(getApplicationContext(), "Grabación correctamente ;)", Toast.LENGTH_LONG).show();
            Button btnGuardar = (Button) findViewById(R.id.btnGuardar);
            btnGuardar.setEnabled(false);

        }
        catch (Exception ex) {
            Utils.ShowMessage(this,"Error al grabar la compra",ex.getMessage());
        }
    }
    private String validarIngresoDatos() {
        String msgReturn = "";

        TextView txtFechaSalida = (TextView) findViewById(R.id.txtFechaSalida);
        TextView txtcodigoItem = (TextView) findViewById(R.id.txtcodigoItem);
        TextView txtDescripcion = (TextView) findViewById(R.id.txtDescripcion);
        TextView txtAreaSolicitante = (TextView) findViewById(R.id.txtAreaSolicitante);
        TextView txtentreadoA = (TextView) findViewById(R.id.txtentreadoA);
        TextView txtCantidad = (TextView) findViewById(R.id.txtCantidad);
        TextView txtPrecioUnitario = (TextView) findViewById(R.id.txtPrecioUnitario);
        TextView txtPrecioTotal = (TextView) findViewById(R.id.txtPrecioTotal);

        if (txtFechaSalida.getText().toString().trim().length() == 0)
            return "Debe ingresar Fecha Salida";
        if (txtcodigoItem.getText().toString().trim().length() == 0)
            return "Debe ingresar código de Item";
        if (txtDescripcion.getText().toString().trim().length() == 0)
            return "Debe ingresar Descripción";
        if (txtAreaSolicitante.getText().toString().trim().length() == 0)
            return "Debe ingresar área solicitante";
        if (txtentreadoA.getText().toString().trim().length() == 0)
            return "Debe ingresar a quién se entrega";
        if (txtCantidad.getText().toString().trim().length() == 0)
            return "Debe ingresar Cantidad";
        if (txtPrecioUnitario.getText().toString().trim().length() == 0)
            return "Debe ingresar Precio Unitario";
        if (txtPrecioTotal.getText().toString().trim().length() == 0)
            return "Debe ingresar Precio Total";

        return "";
    }
}
