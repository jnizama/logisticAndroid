package com.example.ronald.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ronald.data.entities.Compra;
import com.example.ronald.data.entities.DetalleCompra;
import com.example.ronald.data.entities.User;

/**
 * Created by Jorge on 21/06/17.
 */

public class DataCompras {
    Context context;
    public static final String TABLE_COMPRAS = "Compras";
    public static final String ID = "_id";
    public static final String NUMSOLICITU = "numsolicitud";
    public static final String FECHA = "fecha";
    public static final String DPTO = "departamento";
    public static final String NOMBRERESPONSABLE = "nombresresponsable";
    //public static final String APELLIDOBRERESPONSABLE = "apellidoresponsable";
    public static final String DNIRESPONSABLE = "dniresponsable";

    SQLiteDatabase db;

    public DataCompras(Context context) {
        this.context = context;
        db = DatabaseHelper.getInstance(context).getWritableDatabase();
    }
    public static String getDefinitionTable()
    {
        String TABLE = "CREATE TABLE " + TABLE_COMPRAS + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + NUMSOLICITU + " INT, "
                + FECHA + " TEXT, "
                + DPTO + " TEXT, "
                + NOMBRERESPONSABLE + " TEXT, "
                //+ APELLIDOBRERESPONSABLE + " TEXT, "
                + DNIRESPONSABLE + " TEXT "
                + ")";
        return TABLE;
    }

    public void Insert(Compra compra)
    {
        ContentValues values = new ContentValues();
        values.put(NUMSOLICITU, compra.getNumSolictud ());
        values.put(FECHA, compra.getFecha());
        values.put(DPTO, compra.getAreaSolicitante());
        values.put(NOMBRERESPONSABLE, compra.getNombresApellidos());
        values.put(DNIRESPONSABLE, compra.getDni());

        db.insert(TABLE_COMPRAS,null,values);
    }

}
