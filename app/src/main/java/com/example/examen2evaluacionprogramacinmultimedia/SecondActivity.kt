package com.example.examen2evaluacionprogramacinmultimedia

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {

    private lateinit var nombreTextView: TextView
    private lateinit var valoracionTextView :TextView
    private lateinit var empresaEditText: EditText
    private lateinit var anioEditText: EditText
    private lateinit var botonAtras :Button
    private lateinit var botonSiguiente :Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        nombreTextView=findViewById(R.id.textViewNombre)
        valoracionTextView=findViewById(R.id.textViewValoracion)
        empresaEditText=findViewById(R.id.editTextEmpresa)
        anioEditText=findViewById(R.id.editTextAnio)
        botonAtras=findViewById(R.id.botonAtrasSecond)
        botonSiguiente=findViewById(R.id.botonSiguiente)

        nombreTextView.text = intent.getStringExtra("nombreIntroducido")
        valoracionTextView.text = intent.getStringExtra("valoracionIntroducida")


        botonAtras.setOnClickListener{
            val nombre = nombreTextView.text.toString()
            val valoracion = valoracionTextView.text.toString()

            intent = Intent(this,MainActivity::class.java).apply {
                putExtra("nombreIntroducido",nombre)
                putExtra("valoracionIntroducida",valoracion)
            }
            startActivity(intent)
        }

        botonSiguiente.setOnClickListener{
            val nombre = nombreTextView.text.toString()
            val valoracion = valoracionTextView.text.toString()
            val empresa = empresaEditText.text.toString()
            val anio = anioEditText.text.toString()

            if (empresa.isEmpty() || anio.isEmpty() || anio.toInt() < 0){
                Toast.makeText(this,"Los campos no pueden estar vacios o El año ser Negativo", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            intent = Intent(this,ThirdActivity::class.java).apply {
                putExtra("nombreIntroducido",nombre)
                putExtra("valoracionIntroducida",valoracion)
                putExtra("empresaIntroducida",empresa)
                putExtra("anioIntroducido",anio)
            }
            startActivity(intent)
        }

    }
}