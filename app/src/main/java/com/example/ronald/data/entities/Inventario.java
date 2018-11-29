package com.example.ronald.data.entities;

/**
 * Created by Jorge on 22/06/17.
 */

public class Inventario {
    private String codigoBarras; //Sin Función
    private String codigoProducto;
    private String Titulo;
    private String UnidadInventario;
    private Double PrecioUnidad;
    private String Ubicacion;

    public Inventario() {
    }

    public Inventario(String codigoBarras, String codigoProducto, String titulo, String unidadInventario, Double precioUnidad, String ubicacion) {
        this.codigoBarras = codigoBarras;
        this.codigoProducto = codigoProducto;
        Titulo = titulo;
        UnidadInventario = unidadInventario;
        PrecioUnidad = precioUnidad;
        Ubicacion = ubicacion;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getUnidadInventario() {
        return UnidadInventario;
    }

    public void setUnidadInventario(String unidadInventario) {
        UnidadInventario = unidadInventario;
    }

    public Double getPrecioUnidad() {
        return PrecioUnidad;
    }

    public void setPrecioUnidad(Double precioUnidad) {
        PrecioUnidad = precioUnidad;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }
}
