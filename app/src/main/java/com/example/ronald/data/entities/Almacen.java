package com.example.ronald.data.entities;

/**
 * Created by Jorge on 25/06/17.
 */

public class Almacen {
    private String tipoMovimiento;
    private String fechamovimiento;
    private String codigoitem;
    private String descripcion;
    private String cantidad;
    private String preciounitario;
    private String preciototal;
    private String proveedor;
    private String areasolicitante;
    private String entregadoa;
    private String garantia;

    public Almacen() {
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }


    public String getFechamovimiento() {
        return fechamovimiento;
    }

    public void setFechamovimiento(String fechamovimiento) {
        this.fechamovimiento = fechamovimiento;
    }

    public String getCodigoitem() {
        return codigoitem;
    }

    public void setCodigoitem(String codigoitem) {
        this.codigoitem = codigoitem;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(String preciounitario) {
        this.preciounitario = preciounitario;
    }

    public String getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(String preciototal) {
        this.preciototal = preciototal;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getAreasolicitante() {
        return areasolicitante;
    }

    public void setAreasolicitante(String areasolicitante) {
        this.areasolicitante = areasolicitante;
    }

    public String getEntregadoa() {
        return entregadoa;
    }

    public void setEntregadoa(String entregadoa) {
        this.entregadoa = entregadoa;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }
}
