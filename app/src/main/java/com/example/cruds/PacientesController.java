package com.example.cruds;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import com.example.cruds.DBHelper;
import com.example.cruds.Paciente;

public class PacientesController {

    private DBHelper  DBHelper;
    private String NOMBRE_TABLA = "Pacientes";

    public PacientesController(Context contexto){
        DBHelper = new DBHelper(contexto);
    }
    public long nuevoPaciente(Paciente paciente){
        SQLiteDatabase baseDeDatos = DBHelper.getWritableDatabase();
        ContentValues valoresParaInsertar = new ContentValues();
        valoresParaInsertar.put("nombre", paciente.getNombre());
        valoresParaInsertar.put("edad", paciente.getEdad());
        valoresParaInsertar.put("internado", paciente.getInternado());
        return baseDeDatos.insert(NOMBRE_TABLA, null,valoresParaInsertar);
    }
    public int guardarCambios(Paciente pacienteEditado){
        SQLiteDatabase baseDeDatos = DBHelper.getWritableDatabase();
        ContentValues valoresParaActualizar = new ContentValues();
        valoresParaActualizar.put("nombre",pacienteEditado.getNombre());
        valoresParaActualizar.put("edad",pacienteEditado.getEdad());
        valoresParaActualizar.put("internado",pacienteEditado.getInternado());

        String campoParaActualizar = "id = ?";

        String[] argumentosParaActualizar = {String.valueOf(pacienteEditado.getId())};
        return  baseDeDatos.update(NOMBRE_TABLA,valoresParaActualizar,campoParaActualizar,argumentosParaActualizar);
    }
    public int eliminarPaciente(Paciente paciente){
        SQLiteDatabase baseDeDatos = DBHelper.getWritableDatabase();
        String[] argumentos = {String.valueOf(paciente.getId())};
        return baseDeDatos.delete(NOMBRE_TABLA,"id = ?", argumentos);
    }

    public ArrayList<Paciente> obtenerPacientes(){
        ArrayList<Paciente> pacientes = new ArrayList<>();
        SQLiteDatabase baseDeDatos = DBHelper.getReadableDatabase();
        String[] columnasAConsultar = {"nombre", "edad", "internado", "id"};
        Cursor cursor = baseDeDatos.query(
                NOMBRE_TABLA,
                columnasAConsultar,
                null,
                null,
                null,
                null,
                null
        );
        if (cursor == null){
            return pacientes;
        }
        if (!cursor.moveToFirst()) return pacientes;
        do{
            String nombreObtenidoDeBD = cursor.getString(0);
            int edadObtenidaDeBD = cursor.getInt(1);
            boolean internadoObtenidoDeBD = cursor.getInt(2) == 1;
            long idPaciente = cursor.getLong(3);
            Paciente pacienteObtenidoDeBD = new Paciente(nombreObtenidoDeBD,edadObtenidaDeBD,internadoObtenidoDeBD,idPaciente);
            pacientes.add(pacienteObtenidoDeBD);
        }while (cursor.moveToNext());

        cursor.close();
        return pacientes;
    }
}
