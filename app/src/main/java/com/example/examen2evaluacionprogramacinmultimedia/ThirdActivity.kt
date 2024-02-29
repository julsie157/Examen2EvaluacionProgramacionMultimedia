package com.example.examen2evaluacionprogramacinmultimedia

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class ThirdActivity : AppCompatActivity() {

    private lateinit var nombreTextView: TextView
    private lateinit var valoracionTextView : TextView
    private lateinit var empresaTextView: TextView
    private lateinit var anioTextView: TextView
    private lateinit var botonAtras : Button
    private lateinit var botonGuardar : Button
    private lateinit var botonVer : Button

    private lateinit var db: JuegosComprados

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        db= JuegosComprados(this)

        nombreTextView=findViewById(R.id.textViewNombreThird)
        valoracionTextView=findViewById(R.id.textViewValoracionThird)
        empresaTextView=findViewById(R.id.textViewEmpresaThird)
        anioTextView=findViewById(R.id.textViewAnioThird)
        botonAtras=findViewById(R.id.botonAtrasThird)
        botonGuardar=findViewById(R.id.botonGuardar)
        botonVer=findViewById(R.id.botonVer)

        nombreTextView.text = intent.getStringExtra("nombreIntroducido")
        valoracionTextView.text = intent.getStringExtra("valoracionIntroducida")
        empresaTextView.text = intent.getStringExtra("empresaIntroducida")
        anioTextView.text = intent.getStringExtra("anioIntroducido")

        botonAtras.setOnClickListener{
            val nombre = nombreTextView.text.toString()
            val valoracion = valoracionTextView.text.toString()
            val empresa = empresaTextView.text.toString()
            val anio = anioTextView.text.toString()

            intent = Intent(this,SecondActivity::class.java).apply {
                putExtra("nombreIntroducido",nombre)
                putExtra("valoracionIntroducida",valoracion)
                putExtra("empresaIntroducida",empresa)
                putExtra("anioIntroducido",anio)

            }
            startActivity(intent)
        }

        botonGuardar.setOnClickListener {
            val nombre = nombreTextView.text.toString()
            val valoracion = valoracionTextView.text.toString().toFloat()
            val empresa = empresaTextView.text.toString()
            val anio = anioTextView.text.toString().toInt()


            if (nombre.isEmpty() || valoracion.toString().isEmpty()|| empresa.isEmpty() || anio.toString().isEmpty()){
                Toast.makeText(this,"Los campos no pueden estar vacios",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            val videojuego = Videojuego(nombre,valoracion,empresa,anio)
            db.escribirVideojuego(videojuego)
            Toast.makeText(this,"El juego Se ha guardado En la base",Toast.LENGTH_SHORT).show()

        }

        botonVer.setOnClickListener{
            val intent = Intent (this, SaveActivity::class.java)
            startActivity(intent)
        }
    }
}