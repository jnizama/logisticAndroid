package com.example.ronald.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.ronald.data.entities.Almacen;


/**
 * Created by Jorge on 26/06/17.
 */

public class DataAlmacen {
    Context context;
    public static final String TABLE_ALMACEN = "Almacen";
    public static final String ID = "_id";
    public static final String TIPOMOVIMIENTO = "tipoMovimiento";
    public static final String FECHAMOVIMIENTO = "fechamovimiento";
    public static final String CODIGOITEM = "codigoitem";
    public static final String DESCRIPCION = "descripcion";
    public static final String CANTIDAD = "cantidad";
    public static final String PRECIOUNITARIO = "preciounitario";
    public static final String PRECIOTOTAL = "preciototal";
    public static final String PROVEEDOR = "proveedor";
    public static final String AREASOLICITANTE = "areasolicitante";
    public static final String ENGREGADOA = "entregadoa";
    public static final String GARANTIA = "garantia";

    SQLiteDatabase db;

    public DataAlmacen(Context context) {
        this.context = context;
        db = DatabaseHelper.getInstance(context).getWritableDatabase();
    }
    public static String getDefinitionTable()
    {
        String TABLE = "CREATE TABLE " + TABLE_ALMACEN + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + TIPOMOVIMIENTO + " INT, "
                + FECHAMOVIMIENTO + " TEXT, "
                + CODIGOITEM + " TEXT, "
                + DESCRIPCION + " TEXT, "
                + CANTIDAD + " TEXT ,"
                + PRECIOUNITARIO + " TEXT ,"
                + PRECIOTOTAL + " TEXT ,"
                + PROVEEDOR + " TEXT ,"
                + AREASOLICITANTE + " TEXT ,"
                + ENGREGADOA + " TEXT ,"
                + GARANTIA + " TEXT "
                + ")";
        return TABLE;
    }

    public void Insert(Almacen almacen)
    {
        ContentValues values = new ContentValues();
        values.put(TIPOMOVIMIENTO, almacen.getTipoMovimiento ());
        values.put(FECHAMOVIMIENTO, almacen.getFechamovimiento());
        values.put(CODIGOITEM, almacen.getCodigoitem());
        values.put(DESCRIPCION, almacen.getDescripcion());
        values.put(CANTIDAD, almacen.getCantidad());
        values.put(PRECIOUNITARIO, almacen.getPreciounitario());
        values.put(PRECIOTOTAL, almacen.getPreciototal());
        values.put(PROVEEDOR, almacen.getProveedor());
        values.put(AREASOLICITANTE, almacen.getAreasolicitante());
        values.put(ENGREGADOA, almacen.getEntregadoa());
        values.put(GARANTIA, almacen.getGarantia());

        db.insert(TABLE_ALMACEN,null,values);
    }
}
