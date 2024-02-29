package com.example.examen2evaluacionprogramacinmultimedia

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SaveActivity : AppCompatActivity() {

    private lateinit var listadoTextView: TextView
    private lateinit var db: JuegosComprados
    private lateinit var botonAtras : Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save)

        db= JuegosComprados(this)
        listadoTextView=findViewById(R.id.textViewListado)
        botonAtras=findViewById(R.id.BotonVolverInicio)

        val listadoVideojuegos = db.lecturaVideojuegos()
        val lista = listadoVideojuegos.joinToString("\n"){videojuego ->
            "Nombre: ${videojuego.getNombre()} - Valoracion: ${videojuego.getValoracion()} - Empresa: ${videojuego.getEmpresa()} - Año: ${videojuego.getAnio()}"
        }
        listadoTextView.text = lista

        botonAtras.setOnClickListener{
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
        }


    }


}