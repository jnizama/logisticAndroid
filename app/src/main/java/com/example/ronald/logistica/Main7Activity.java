package com.example.ronald.logistica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ronald.data.DataInventarios;
import com.example.ronald.data.entities.Inventario;
import com.example.ronald.helper.Utils;

public class Main7Activity extends AppCompatActivity {

    private DataInventarios dataInventarios;
    private TextView txtcodProducto;
    private TextView txtDescripcion;
    private TextView txtnumero;
    private TextView txtCuentaActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        dataInventarios = new DataInventarios(this);
        txtcodProducto = (TextView) findViewById(R.id.txtClaveProducto);
        txtDescripcion = (TextView) findViewById(R.id.txtDescripcion);
        txtnumero = (TextView) findViewById(R.id.txtnumero);
        txtCuentaActual = (TextView) findViewById(R.id.txtCuentaActual);
    }
    public void onBuscar(View view)
    {
        String CodProducto = txtcodProducto.getText().toString();
        BuscarxCodigo(CodProducto);
    }
    private void BuscarxCodigo(String codProducto)
    {
        Inventario inventario = dataInventarios.getInventario(codProducto);

        if(!(inventario.getTitulo() == null || inventario.getCodigoProducto() == null))
        {
            txtcodProducto.setText(inventario.getCodigoProducto());
            txtDescripcion.setText(inventario.getTitulo());
            txtnumero.setText(inventario.getUnidadInventario());
            txtCuentaActual.setText(inventario.getUnidadInventario());
        }
        else
        {
            Utils.ShowMessage(this,"Logística","No se encontró el producto");
            return;
        }
    }
    public void Substract(View view)
    {
        if(!(txtCuentaActual.getText().toString().equals("")))
        {
            Integer cuentaActual = Integer.valueOf(txtCuentaActual.getText().toString());
            if(cuentaActual > 0)
                cuentaActual--;
            txtCuentaActual.setText(cuentaActual.toString());
        }

    }
    public void Add(View view)
    {
        if(!(txtCuentaActual.getText().toString().equals("")))
        {
            Integer cuentaActual = Integer.valueOf(txtCuentaActual.getText().toString());
            cuentaActual++;
            txtCuentaActual.setText(cuentaActual.toString());
        }
    }
    public void onGuardar(View view)
    {
        Inventario inventario = new Inventario();
        String CodProducto = txtcodProducto.getText().toString();
        String Titulo = txtDescripcion.getText().toString();
        String UnidadInventario = txtCuentaActual.getText().toString();

        inventario.setCodigoProducto(CodProducto);
        inventario.setTitulo(Titulo);
        inventario.setUnidadInventario(UnidadInventario);

        try
        {
            dataInventarios.ActualizaInventario(inventario);
            Utils.ShowMessage(this,"Inventario","Se ha registrado su inventarios de forma satisfactoria");
            Toast.makeText(getApplicationContext(), "Grabación de la inventarios correctamente ;)", Toast.LENGTH_LONG).show();
            Button btnSave = (Button) findViewById(R.id.buttonGuardar);
            //btnSave.setEnabled(false);
        }
        catch (Exception ex) {
            Utils.ShowMessage(this,"Error al grabar",ex.getMessage());
        }

    }
    public void onCancelar(View view)
    {
        this.onBackPressed();
    }
}
