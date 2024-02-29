package com.example.examen2evaluacionprogramacinmultimedia

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper



// Clase DatabaseHelper
class JuegosComprados(context: Context) : SQLiteOpenHelper(context, DATABASE, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_VERSION = 2
        private const val DATABASE = "db"
        private const val TABLA_VIDEOJUEGOS = "Videojuegos"
        private const val KEY_ID = "id"
        private const val COLUMN_NOMBRE = "nombre"
        private const val COLUMN_VALORACION = "valoracion"
        private const val COLUMN_EMPRESA = "empresa"
        private const val COLUMN_ANIO = "anio"

    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = "CREATE TABLE $TABLA_VIDEOJUEGOS($KEY_ID INTEGER PRIMARY KEY, $COLUMN_NOMBRE TEXT, $COLUMN_VALORACION FLOAT, $COLUMN_EMPRESA TEXT, $COLUMN_ANIO INTEGER)"
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLA_VIDEOJUEGOS")
        onCreate(db)
    }

    fun escribirVideojuego(videojuego: Videojuego){
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NOMBRE, videojuego.getNombre())
            put(COLUMN_VALORACION, videojuego.getValoracion())
            put(COLUMN_EMPRESA, videojuego.getEmpresa())
            put(COLUMN_ANIO, videojuego.getAnio())
        }
        db.insert(TABLA_VIDEOJUEGOS, null, values)
        db.close()
    }


    @SuppressLint("Range")
    fun lecturaVideojuegos(): ArrayList<Videojuego> {
        val lectura = ArrayList<Videojuego>()
        val selectQuery = "SELECT * FROM $TABLA_VIDEOJUEGOS"
        val db = this.readableDatabase
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndex(KEY_ID))
                val nombre = cursor.getString(cursor.getColumnIndex(COLUMN_NOMBRE))
                val valoracion = cursor.getFloat(cursor.getColumnIndex(COLUMN_VALORACION))
                val empresa = cursor.getString(cursor.getColumnIndex(COLUMN_EMPRESA))
                val anio = cursor.getInt(cursor.getColumnIndex(COLUMN_ANIO))
                lectura.add(Videojuego(nombre, valoracion , empresa,anio))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return lectura
    }

}


