package com.example.ronald.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.ronald.data.entities.Compra;
import com.example.ronald.data.entities.DetalleCompra;

/**
 * Created by Jorge on 21/06/17.
 */

public class DataDetalleCompras {
    public static final String TABLE_DETALLECOMPRAS = "DetalleCompras";

    public static final String ID = "_id";
    public static final String CODITEM = "codigoitem";
    public static final String DESCRIPCION = "descripcion";
    public static final String CANTIDAD = "cantidad";
    public static final String PRECIOUNITARIO = "preciounitario";
    public static final String TOTAL = "total";

    SQLiteDatabase db;

    public DataDetalleCompras(Context context) {
//        DatabaseHelper.SQLCREATOR = "CREATE TABLE " + TABLE_DETALLECOMPRAS + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
//                + CODITEM + " INT, "
//                + DESCRIPCION + " TEXT, "
//                + CANTIDAD + " TEXT, "
//                + PRECIOUNITARIO + " TEXT, "
//                + TOTAL + " TEXT "
//                + ")";

        db = DatabaseHelper.getInstance(context).getWritableDatabase();
    }
    public static String getDefinitionTable()
    {
        String TABLE = "CREATE TABLE " + TABLE_DETALLECOMPRAS + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + CODITEM + " INT, "
                + DESCRIPCION + " TEXT, "
                + CANTIDAD + " TEXT, "
                + PRECIOUNITARIO + " TEXT, "
                + TOTAL + " TEXT "
                + ")";
        return TABLE;
    }
    public void Insert(DetalleCompra detalleCompra)
    {

        ContentValues values = new ContentValues();
        values.put(CODITEM, detalleCompra.getCodigoItem ());
        values.put(DESCRIPCION, detalleCompra.getDescripcion());
        values.put(CANTIDAD, detalleCompra.getCantidad());
        values.put(PRECIOUNITARIO, detalleCompra.getPrecioUnit());
        values.put(TOTAL, detalleCompra.getPrecioTotal());

        db.insert(TABLE_DETALLECOMPRAS,null,values);
    }

}
