package com.example.app_pokemon

data class Equipo(
    val id: Int,
    val name: String,
    val campeonatos: Int,
    val pais: Pais,
    val url: String,
)

enum class Pais {
    ARGENTINA, BRASIL, INGLATERRA
}


