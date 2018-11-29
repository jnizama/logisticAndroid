package com.example.ronald.logistica;

import android.app.ActivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ronald.data.DataInventarios;
import com.example.ronald.data.entities.Inventario;
import com.example.ronald.helper.Utils;

import java.math.BigDecimal;

public class Main6Activity extends AppCompatActivity {

    private TextView txtcodProducto;
    private TextView txtTitulo;
    private TextView txtUnidadInventario;
    private TextView txtPrecioUnit;
    private TextView txtUbicacion;

    private DataInventarios dataInventarios;
    private boolean canGuardar = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        dataInventarios = new DataInventarios(this);

        txtcodProducto = (TextView) findViewById(R.id.txtcodProducto);
        txtTitulo = (TextView) findViewById(R.id.txtTitulo);
        txtUnidadInventario = (TextView) findViewById(R.id.txtUnidadInventario);
        txtPrecioUnit = (TextView) findViewById(R.id.txtPrecioUnitario);
        txtUbicacion = (TextView) findViewById(R.id.txtUbicacion);

//        Inventario inventario = new Inventario();
//
//        txtcodProducto.setText(inventario.getCodigoProducto());
//        txtTitulo.setText(inventario.getTitulo());
//        txtUnidadInventario.setText(inventario.getUnidadInventario());
//        txtPrecioUnit.setText(inventario.getPrecioUnidad().toString());
//        txtUbicacion.setText(inventario.getUbicacion().toString());

    }
    public void onBuscar(View view)
    {
        String CodProducto = txtcodProducto.getText().toString();
        BuscarxCodigo(CodProducto);
    }
    public void onGuardar(View view)
    {
        if(canGuardar)
        {
            Inventario inventario = new Inventario();
            String CodProducto = txtcodProducto.getText().toString();
            String Titulo = txtTitulo.getText().toString();
            String UnidadInventario = txtUnidadInventario.getText().toString();
            Double PrecioUnit = Double.valueOf(txtPrecioUnit.getText().toString());
            String Ubicacion = txtUbicacion.getText().toString();

            inventario.setCodigoProducto(CodProducto);
            inventario.setTitulo(Titulo);
            inventario.setUnidadInventario(UnidadInventario);
            inventario.setPrecioUnidad(PrecioUnit);
            inventario.setUbicacion(Ubicacion);

            try
            {
                dataInventarios.InsertInventario(inventario);
                Utils.ShowMessage(this,"Inventario","Se ha registrado su inventarios de forma satisfactoria");
                Toast.makeText(getApplicationContext(), "Grabación de la inventarios correctamente ;)", Toast.LENGTH_LONG).show();
                Button btnSave = (Button) findViewById(R.id.buttonGuardar);
                //btnSave.setEnabled(false);
            }
            catch (Exception ex) {
                Utils.ShowMessage(this,"Error al grabar",ex.getMessage());
            }
        }
        else
            Utils.ShowMessage(this,"Logística","Debe buscar un producto antes de poder guardarlo");
    }
    private void BuscarxCodigo(String codigo)
    {
        Inventario inventario = dataInventarios.getInventario(codigo);
        if(!(inventario.getTitulo() == null || inventario.getCodigoProducto() == null))
            canGuardar = true;
        else
        {
            Utils.ShowMessage(this,"Logística","No se encontró el producto");
            canGuardar = false;
            return;
        }

        txtcodProducto.setText(inventario.getCodigoProducto());
        txtTitulo.setText(inventario.getTitulo());
        txtUnidadInventario.setText(inventario.getUnidadInventario());
        String preUnit = inventario.getPrecioUnidad().toString();

        txtPrecioUnit.setText(preUnit);
        txtUbicacion.setText(inventario.getUbicacion());
    }
    private void ActualizarItem(String codigo)
    {
        txtcodProducto.setText("");
        txtTitulo.setText("");
        txtUnidadInventario.setText("");
        txtPrecioUnit.setText("");
        txtUbicacion.setText("");
    }
    public void onCancelar(View view)
    {
        this.onBackPressed();
    }
}
