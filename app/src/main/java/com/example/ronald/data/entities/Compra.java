package com.example.ronald.data.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Jorge on 20/06/17.
 */

public class Compra implements Serializable {
    public String NumSolictud;
    public String Fecha;
    public String AreaSolicitante;
    public String NombresApellidos;
    public String Dni;
    public DetalleCompra Detalles;
    //public List<DetalleCompra> Detalles;

    public Compra() {
    }

    public Compra(String numSolictud, String fecha, String areaSolicitante, String nombresApellidos, String dni) {
        NumSolictud = numSolictud;
        Fecha = fecha;
        AreaSolicitante = areaSolicitante;
        NombresApellidos = nombresApellidos;
        Dni = dni;
    }
    public DetalleCompra getDetalles() {
        return Detalles;
    }

    public void setDetalles(DetalleCompra detalles) {
        Detalles = detalles;
    }



    public String getNumSolictud() {
        return NumSolictud;
    }

    public void setNumSolictud(String numSolictud) {
        NumSolictud = numSolictud;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getAreaSolicitante() {
        return AreaSolicitante;
    }

    public void setAreaSolicitante(String areaSolicitante) {
        AreaSolicitante = areaSolicitante;
    }

    public String getNombresApellidos() {
        return NombresApellidos;
    }

    public void setNombresApellidos(String nombresApellidos) {
        NombresApellidos = nombresApellidos;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String dni) {
        Dni = dni;
    }


}
