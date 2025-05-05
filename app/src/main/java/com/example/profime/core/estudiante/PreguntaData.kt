package com.example.profime.core.estudiante

data class Pregunta(
    val texto: String,
    val opciones: List<String>,
    val respuestaCorrecta: Int // Índice de la opción correcta
)

val listaPreguntas = listOf(
    Pregunta(
        texto = "¿Qué hace un procesador?",
        opciones = listOf("Ejecuta instrucciones", "Almacena datos", "Dibuja gráficos", "Maneja la red"),
        respuestaCorrecta = 0
    ),
    Pregunta(
        texto = "¿Cuál es la función de la RAM?",
        opciones = listOf("Ejecutar programas", "Almacenar permanentemente", "Procesar gráficos", "Ninguna de las anteriores"),
        respuestaCorrecta = 0
    ),
    Pregunta(
        texto = "¿Para qué se usan los diagramas de flujo?",
        opciones = listOf("Para programar directamente", "Para representar algoritmos", "Para diseñar interfaces", "Para almacenar datos"),
        respuestaCorrecta = 1
    )
)