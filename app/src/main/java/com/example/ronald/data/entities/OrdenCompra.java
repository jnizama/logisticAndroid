package com.example.ronald.data.entities;

import java.io.Serializable;

/**
 * Created by Jorge on 25/06/17.
 */

public class OrdenCompra implements Serializable {
    private String numeroOrden;
    private String ruc;
    private String descripcion;
    private String proveedor;
    private int cantidad;
    private double preciounitario;
    private double preciototal;

    public OrdenCompra() {
    }

    public OrdenCompra(String numeroOrden, String ruc, String descripcion, String proveedor, int cantidad, double preciounitario, double preciototal) {
        this.numeroOrden = numeroOrden;
        this.ruc = ruc;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
        this.cantidad = cantidad;
        this.preciounitario = preciounitario;
        this.preciototal = preciototal;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(String numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(double preciounitario) {
        this.preciounitario = preciounitario;
    }

    public double getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(double preciototal) {
        this.preciototal = preciototal;
    }
}
