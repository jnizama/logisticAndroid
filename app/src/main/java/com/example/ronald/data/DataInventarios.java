package com.example.ronald.data;

import android.content.ContentValues;
import android.content.Context;
import android.content.SyncContext;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;

import com.example.ronald.data.entities.Inventario;
import com.example.ronald.data.entities.User;

/**
 * Created by Jorge on 22/06/17.
 */

public class DataInventarios {
    Context context;

    public static final String TABLE_INVENTARIO = "Inventario";

    public static final String ID = "_id";
    public static final String CODIGOBARRAS = "codigobarras";
    public static final String CODIGOPRODUCTO = "codigoproducto";
    public static final String DESCRIPCION = "descripcion";
    public static final String UNIDADESINVENTARIO = "unidadesinventario";
    public static final String PRECIOUNIDAD = "preciounidad";
    public static final String UBICACION = "ubicacion";

    SQLiteDatabase db;

    public DataInventarios(Context context) {

        this.context = context;
        db = DatabaseHelper.getInstance(context).getWritableDatabase();
        if(db !=null)
        {
            CrearFakeInventario();
        }
    }
    public static String getDefinitionTable()
    {
        String TABLE = "CREATE TABLE " + TABLE_INVENTARIO + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + CODIGOBARRAS + " INT, "
                + CODIGOPRODUCTO + " TEXT, "
                + DESCRIPCION + " TEXT, "
                + UNIDADESINVENTARIO + " TEXT, "
                + PRECIOUNIDAD + " TEXT, "
                + UBICACION + " TEXT "
                + ")";
        return TABLE;
    }

    public Inventario getInventario(String CodigoProducto)
    {
        Inventario inventario = new Inventario();
        String[] columns = new String[] { ID,CODIGOPRODUCTO,DESCRIPCION,UNIDADESINVENTARIO,PRECIOUNIDAD,UBICACION };
        String where = CODIGOPRODUCTO + " =?";
        String[] values = new String[] { String.valueOf(CodigoProducto) };
        Cursor result = db.query(TABLE_INVENTARIO, columns, where, values, null, null, null );

        if(result.moveToFirst())
        {
            do{
                String codigoproducto = result.getString(result.getColumnIndex("codigoproducto"));
                String descripcion = result.getString(result.getColumnIndex("descripcion"));
                String unidadesinventario = result.getString(result.getColumnIndex("unidadesinventario"));
                Double preciounidad = result.getDouble(result.getColumnIndex("preciounidad"));
                String ubicacion = result.getString(result.getColumnIndex("ubicacion"));

                inventario.setCodigoProducto(codigoproducto);
                inventario.setTitulo(descripcion);
                inventario.setUnidadInventario(unidadesinventario);
                inventario.setPrecioUnidad(preciounidad);
                inventario.setUbicacion(ubicacion);

            }while(result.moveToNext());
        }
        result.close();

        //String Titulo = result.getString( result.getColumnIndex("titulo") );
        //inventario.setTitulo(result.getString(1));

        return inventario;
    }
    public void CrearFakeInventario()
    {
        Cursor result = db.query(TABLE_INVENTARIO, null, null, null, null, null, null, null );
        if(result.getCount() < 1)
        {
            InsertInventario(new Inventario("","001","LAPTOP HP iCore 7","1",1200.00, "Sala A1B"));
            InsertInventario(new Inventario("","002","CAMARA PANASONIC 10mpx","5",600.50, "Sala A1B"));
            InsertInventario(new Inventario("","003","TV LCD 33 PULGADAS","10",1899.00, "Sala A1B"));
        }

    }
    public void InsertInventario(Inventario inventario)
    {
        ContentValues values = new ContentValues();
        values.put(CODIGOBARRAS, inventario.getCodigoBarras ());
        values.put(CODIGOPRODUCTO, inventario.getCodigoProducto ());
        values.put(DESCRIPCION, inventario.getTitulo ());
        values.put(UNIDADESINVENTARIO, inventario.getUnidadInventario ());
        values.put(PRECIOUNIDAD, inventario.getPrecioUnidad ());
        values.put(UBICACION, inventario.getUbicacion ());

        db.insert(TABLE_INVENTARIO,null,values);
    }
    public void ActualizaInventario(Inventario inventario)
    {
        ContentValues values = new ContentValues();
        //values.put(CODIGOBARRAS, inventario.getCodigoBarras ());
        //values.put(CODIGOPRODUCTO, inventario.getCodigoProducto ());
        values.put(DESCRIPCION, inventario.getTitulo ());
        values.put(UNIDADESINVENTARIO, inventario.getUnidadInventario ());
        //values.put(PRECIOUNIDAD, inventario.getPrecioUnidad ());
        //values.put(UBICACION, inventario.getUbicacion ());

        db.update(TABLE_INVENTARIO,values, CODIGOPRODUCTO + "='" + inventario.getCodigoProducto() + "'" , null);

    }
}
