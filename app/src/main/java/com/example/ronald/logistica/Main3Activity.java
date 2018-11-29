package com.example.ronald.logistica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ronald.data.entities.Compra;
import com.example.ronald.helper.Utils;

public class Main3Activity extends AppCompatActivity {

    private Compra myCompra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        myCompra = new Compra();


    }
    public void onDetalleRequerimiento(View view)
    {
        String msg = validarIngresoDatos();
        if (msg != "")
        {
            Utils.ShowMessage(this,"Validación" ,msg);
            return;
        }


        Intent nextActivity = new Intent(this, Main4Activity.class);
        nextActivity.putExtra("MyCompra", myCompra);
        startActivity(nextActivity);
    }
    public void RegresarMenuPrincipal(View view)
    {
        super.onBackPressed();
    }

    private String validarIngresoDatos() {
        String msgReturn = "";

        TextView txtNumSolicitud = (TextView) findViewById(R.id.txtnumero);
        TextView txtFechaSolicitud = (TextView) findViewById(R.id.txtFechaSolicitud);
        TextView txtAreaSolicitante = (TextView) findViewById(R.id.txtDescripcion);
        TextView txtNombreApellidos = (TextView) findViewById(R.id.txtNombreApellidos);
        TextView txtNumDni = (TextView) findViewById(R.id.txtNumDni);

        if (txtNumSolicitud.getText().toString().trim().length() == 0)
            return "Debe ingresar Número de solicitud";
        if (txtFechaSolicitud.getText().toString().trim().length() == 0)
            return "Debe ingresar Fecha solicitud ";
        if (txtAreaSolicitante.getText().toString().trim().length() == 0)
            return "Debe ingresar Area solicitante";
        if (txtNombreApellidos.getText().toString().trim().length() == 0)
            return "Debe ingresar Nombres y Apellidos";
        if (txtNumDni.getText().toString().trim().length() == 0)
            return "Debe ingresar DNI";

        myCompra.setNumSolictud(txtNumSolicitud.getText().toString().trim());
        myCompra.setAreaSolicitante(txtAreaSolicitante.getText().toString().trim());
        myCompra.setDni(txtNumDni.getText().toString().trim());
        myCompra.setFecha(txtFechaSolicitud.getText().toString().trim());
        myCompra.setNombresApellidos(txtNombreApellidos.getText().toString().trim());

        return "";
    }


}
