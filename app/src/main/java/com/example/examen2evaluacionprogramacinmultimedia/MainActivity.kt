package com.example.examen2evaluacionprogramacinmultimedia

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var nombreEditText: EditText
    private lateinit var valoracionEditText : EditText
    private lateinit var botonContinuar : Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nombreEditText = findViewById(R.id.editTextNombre)
        valoracionEditText = findViewById(R.id.editTextValoracion)
        botonContinuar = findViewById(R.id.botonContinuar)


        botonContinuar.setOnClickListener{
            val nombre = nombreEditText.text.toString()
            val valoracion = valoracionEditText.text.toString()

            if (nombre.isEmpty() || valoracion.isEmpty() || valoracion.toFloat() < 0 || valoracion.toFloat() > 10.00){
                Toast.makeText(this,"Los campos no pueden estar vacios o la Valoracion no esta entre 0 - 10", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            intent = Intent(this,SecondActivity::class.java).apply {
                putExtra("nombreIntroducido",nombre)
                putExtra("valoracionIntroducida",valoracion)
            }
            startActivity(intent)
        }
    }
}