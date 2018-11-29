package com.example.ronald.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jorge on 20/06/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper sInstance;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "dbAlmacen.sqlite";   // Database Name
    public static  String SQLCREATOR = "";     // SQL Creator

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL(SQLCREATOR);
        db.execSQL(DataUser.getDefinitionTable());
        db.execSQL(DataCompras.getDefinitionTable());
        db.execSQL(DataDetalleCompras.getDefinitionTable());
        db.execSQL(DataInventarios.getDefinitionTable());
        db.execSQL(DataOrdenCompras.getDefinitionTable());
        SQLCREATOR = "";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public static synchronized DatabaseHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }
}
