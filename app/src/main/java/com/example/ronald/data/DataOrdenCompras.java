package com.example.ronald.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ronald.data.entities.Compra;
import com.example.ronald.data.entities.OrdenCompra;

/**
 * Created by Jorge on 25/06/17.
 */

public class DataOrdenCompras {
    Context context;
    public static final String TABLE_ORDENCOMPRAS = "OrdenCompras";
    public static final String ID = "_id";
    public static final String NUMORDEN = "numorden";
    public static final String DESCRIPCION = "descripcion";
    public static final String CANTIDAD = "cantidad";
    public static final String RUC = "ruc";
    public static final String PROVEEDOR = "proveedor";
    public static final String PRECIOUNITARIO = "preciounitario";
    public static final String PRECIOTOTAL = "preciototal";

    SQLiteDatabase db;

    public DataOrdenCompras(Context context) {
        this.context = context;
        db = DatabaseHelper.getInstance(context).getWritableDatabase();

        CrearFakeOrdenCompras();
    }

    private void CrearFakeOrdenCompras() {
        Cursor result = db.query(TABLE_ORDENCOMPRAS, null, null, null, null, null, null, null );
        if(result.getCount() < 1)
        {
            Insert(new OrdenCompra("001", "99569840381", "COMPRA DE UTILES","ABC SAC", 1, 12.21, 12.21));
            Insert(new OrdenCompra("002", "09569840388", "ARQUILER DE SERVIDOR PIII","NICOLI SAC", 10, 1900, 19000));
            Insert(new OrdenCompra("003", "11569840384", "COMPRA DE PAPEL","FUEGO EN LAS MALVINAS SAC", 2, 1200, 2400));
        }
    }

    public static String getDefinitionTable()
    {
        String TABLE = "CREATE TABLE " + TABLE_ORDENCOMPRAS + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + NUMORDEN + " TEXT, "
                + DESCRIPCION + " TEXT, "
                + CANTIDAD + " TEXT, "
                + RUC + " TEXT, "
                + PROVEEDOR + " TEXT, "
                + PRECIOUNITARIO + " TEXT, "
                + PRECIOTOTAL + " TEXT "
                + ")";
        return TABLE;
    }

    public void Insert(OrdenCompra ordenCompra)
    {
        ContentValues values = new ContentValues();
        values.put(NUMORDEN, ordenCompra.getNumeroOrden ());
        values.put(DESCRIPCION, ordenCompra.getDescripcion());
        values.put(CANTIDAD, ordenCompra.getCantidad());
        values.put(RUC, ordenCompra.getRuc());
        values.put(PROVEEDOR, ordenCompra.getProveedor());
        values.put(PRECIOUNITARIO, ordenCompra.getPreciounitario());
        values.put(PRECIOTOTAL, ordenCompra.getPreciototal());

        db.insert(TABLE_ORDENCOMPRAS,null,values);
    }
    public OrdenCompra Buscar(String numOrden, String ruc)
    {
        OrdenCompra ordenCompra = new OrdenCompra();
        //ContentValues values = new ContentValues();
        String[] values = new String[] {};
        String[] columns = new String[] { NUMORDEN, DESCRIPCION,PROVEEDOR,CANTIDAD,RUC,PRECIOUNITARIO,PRECIOTOTAL };
        String where = "";
        if(numOrden.length() > 1)
        {
            where = NUMORDEN + " =?";
            values = new String[] { String.valueOf(numOrden) };
        }
        if(ruc.length() > 1)
        {
            where = RUC + " =?";
            values = new String[] { String.valueOf(ruc) };
        }

        Cursor result = db.query(TABLE_ORDENCOMPRAS, columns, where, values, null, null, null );

        if(result.moveToFirst()) {
            do {
                String numorden = result.getString(result.getColumnIndex(NUMORDEN));
                String descripcion = result.getString(result.getColumnIndex(DESCRIPCION));
                String proveedor = result.getString(result.getColumnIndex(PROVEEDOR));
                String cantidad = result.getString(result.getColumnIndex(CANTIDAD));
                int cant = Integer.valueOf(cantidad);
                String _ruc = result.getString(result.getColumnIndex(RUC));
                String preciounitario = result.getString(result.getColumnIndex(PRECIOUNITARIO));
                Double precunit = Double.valueOf(preciounitario);
                String preciototal = result.getString(result.getColumnIndex(PRECIOTOTAL));
                Double prectotal = Double.valueOf(preciototal);

                ordenCompra.setNumeroOrden(numorden);
                ordenCompra.setDescripcion(descripcion);
                ordenCompra.setProveedor(proveedor);
                ordenCompra.setCantidad(cant);
                ordenCompra.setRuc(_ruc);
                ordenCompra.setPreciounitario(precunit);
                ordenCompra.setPreciototal(prectotal);

            }while(result.moveToNext());
        }
        return ordenCompra;
    }
}
