package com.coronado.clinica

data class Medico(
    val id: Int,
    val nombre: String,
    val especialidad: String,
    val calificacion: Double
)

val medicos = listOf(

    Medico(
        id = 1,
        nombre = "Dr. Carlos Ramírez",
        especialidad = "Cardiología",
        calificacion = 4.8
    ),

    Medico(
        id = 2,
        nombre = "Dra. María López",
        especialidad = "Pediatría",
        calificacion = 4.9
    ),

    Medico(
        id = 3,
        nombre = "Dr. José Torres",
        especialidad = "Dermatología",
        calificacion = 4.7
    )
)