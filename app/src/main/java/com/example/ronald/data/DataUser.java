package com.example.ronald.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ronald.data.entities.User;

/**
 * Created by Jorge on 20/06/17.
 */

public class DataUser {
    public static final String TABLE_USER = "Usuario";

    public static final String ID = "_id";
    public static final String USUARIO = "usuario";
    public static final String PASSWORD = "password";



    SQLiteDatabase db;

    public DataUser(Context context) {
//        DatabaseHelper.SQLCREATOR = "CREATE TABLE " + TABLE_USER + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
//                + USUARIO + " INT, "
//                + PASSWORD + " TEXT "
//                + ")";

        db = DatabaseHelper.getInstance(context).getWritableDatabase();
        CrearFakeUsuarios();
    }
    public static String getDefinitionTable()
    {
        String TABLE = "CREATE TABLE " + TABLE_USER + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + USUARIO + " INT, "
                + PASSWORD + " TEXT "
                + ")";
        return TABLE;
    }
    public boolean ValidarCredenciales(String Usuario, String Password) {
        boolean validacion = false;
        Cursor result = getUsuario(Usuario);
        if(result.getCount() > 0)
            validacion = true;
        return validacion;

    }
    public Cursor getUsuario(String Street)
    {
        String[] columns = new String[] { ID };
        String where = USUARIO + " =?";
        String[] values = new String[] { String.valueOf(Street) };
        return   db.query(TABLE_USER, columns, where, values, null, null, null );
    }
    public void CrearFakeUsuarios()
    {
        Cursor result = db.query(TABLE_USER, null, null, null, null, null, null, null );
        if(result.getCount() < 1)
        {
            InsertUsuario(new User("AOROSCO", "123"));
            InsertUsuario(new User("RCERRON", "2017"));
            InsertUsuario(new User("RPACHECO", "1234"));
        }

    }
    public void InsertUsuario(User Usuario)
    {
        ContentValues values = new ContentValues();
        values.put(USUARIO, Usuario.getUsuario ());
        values.put(PASSWORD, Usuario.getPassword());

        db.insert(TABLE_USER,null,values);
    }
}
