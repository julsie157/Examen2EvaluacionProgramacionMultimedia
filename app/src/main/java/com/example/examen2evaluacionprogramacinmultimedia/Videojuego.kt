package com.example.examen2evaluacionprogramacinmultimedia

class Videojuego(
    private var nombre : String,
    private var valoracion : Float,
    private  var empresa : String,
    private var anio : Int
) {

    fun getNombre() = nombre
    fun getValoracion() = valoracion
    fun getEmpresa() = empresa
    fun getAnio() = anio

}