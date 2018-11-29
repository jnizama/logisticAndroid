package com.example.ronald.data.entities;

/**
 * Created by Jorge on 20/06/17.
 */

public class DetalleCompra {
    public String CodigoItem;
    public String Descripcion;
    public Integer Cantidad;
    public Double PrecioUnit;
    public Double PrecioTotal;

    public DetalleCompra(String codigoItem, String descripcion, Integer cantidad, Double precioUnit, Double precioTotal) {
        CodigoItem = codigoItem;
        Descripcion = descripcion;
        Cantidad = cantidad;
        PrecioUnit = precioUnit;
        PrecioTotal = precioTotal;
    }

    public String getCodigoItem() {
        return CodigoItem;
    }

    public void setCodigoItem(String codigoItem) {
        CodigoItem = codigoItem;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Integer getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Integer cantidad) {
        Cantidad = cantidad;
    }

    public Double getPrecioUnit() {
        return PrecioUnit;
    }

    public void setPrecioUnit(Double precioUnit) {
        PrecioUnit = precioUnit;
    }

    public Double getPrecioTotal() {
        return PrecioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        PrecioTotal = precioTotal;
    }
}
