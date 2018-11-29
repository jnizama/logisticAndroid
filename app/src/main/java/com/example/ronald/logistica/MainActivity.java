package com.example.ronald.logistica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ronald.data.DataCompras;
import com.example.ronald.data.DataDetalleCompras;
import com.example.ronald.data.DataInventarios;
import com.example.ronald.data.DataUser;
import com.example.ronald.data.entities.DetalleCompra;
import com.example.ronald.helper.Utils;

public class MainActivity extends AppCompatActivity {

    private DataUser dataUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataUser = new DataUser(this);

//        DataCompras dataCompras = new DataCompras(this.getApplicationContext());
//        dataCompras.CreateTable();
//
//        DataDetalleCompras dataDetalleCompras = new DataDetalleCompras(this.getApplicationContext());
//        DataInventarios dataInventarios = new DataInventarios(this.getApplicationContext());
//        dataInventarios.CreateTable();

        //dataInventarios.CrearFakeInventario();
    }
    public void onIngresar(View view)
    {
        TextView txtUsuario = (TextView) findViewById(R.id.input_usuario);
        TextView txtPassword = (TextView) findViewById(R.id.input_contrasena);
        if(!ValidarUsuario(txtUsuario.getText().toString(), txtPassword.getText().toString()))
        {
            Utils.ShowMessage(this,"Sin acceso","No tiene acceso con las credenciales proporcionadas");
            return;
        }
        Toast.makeText(getApplicationContext(), "Bienvenido a nuestro sistema de almacén. ;)", Toast.LENGTH_LONG).show();
        Intent nextActivity = new Intent(this, Main2Activity.class);
        startActivity(nextActivity);

    }
    private boolean ValidarUsuario(String Usuario, String Password)
    {
        return dataUser.ValidarCredenciales(Usuario, Password);
    }
}
