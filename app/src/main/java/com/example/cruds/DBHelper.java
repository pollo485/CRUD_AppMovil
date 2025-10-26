package com.example.cruds;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DBHelper extends SQLiteOpenHelper{
     private static final String NONBRE_BASE_DE_DATOS = "Pacientes",
               NOMBRE_TABLA_PACIENTES = "Pacientes";
     private static final int VERSION_BASE_DE_DATOS = 1;

     public DBHelper(Context context){
          super(context, NONBRE_BASE_DE_DATOS, null, VERSION_BASE_DE_DATOS);
     }

     @Override
     public void onCreate(SQLiteDatabase db){
          db.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s(id integer primary key autoincrement, nombre text, edad int, internado integer)", NOMBRE_TABLA_PACIENTES));
     }

     @Override
     public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

     }
}
