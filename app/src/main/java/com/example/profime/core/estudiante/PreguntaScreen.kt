package com.example.profime.core.estudiante

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun PreguntaScreen(navController: NavController, tema: String) {
    var preguntaIndex by remember { mutableStateOf(0) }
    val listaPreguntas = obtenerPreguntasPorTema(tema)

    // **Depuración: Verificar si hay preguntas cargadas**
    println("Preguntas cargadas: ${listaPreguntas.size}")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Preguntas sobre $tema",
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // **Indicador de progreso**
        LinearProgressIndicator(
            progress = if (listaPreguntas.isNotEmpty()) preguntaIndex.toFloat() / listaPreguntas.size else 0f,
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .clip(RoundedCornerShape(4.dp)),
            color = Color(0xFF1E88E5)
        )
        Spacer(modifier = Modifier.height(16.dp))

        if (listaPreguntas.isNotEmpty() && preguntaIndex < listaPreguntas.size) {
            PreguntaItem(
                pregunta = listaPreguntas[preguntaIndex],
                onAnswerCorrect = {
                    if (preguntaIndex < listaPreguntas.size - 1) {
                        preguntaIndex += 1
                        println("Siguiente pregunta: $preguntaIndex") // Debug
                    } else {
                        println("Fin del cuestionario") // Debug
                    }
                }
            )
        } else {
            // **Mensaje de finalización**
            Text(
                text = "🎉 ¡Has respondido todas las preguntas correctamente!",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                color = Color(0xFF1E88E5)
            )
        }
    }
}

@Composable
fun PreguntaItem(pregunta: Pregunta, onAnswerCorrect: () -> Unit) {
    var seleccion by remember { mutableStateOf(-1) }
    var resultado by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.White, shape = RoundedCornerShape(12.dp))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = pregunta.texto,
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 12.dp)
        )

        pregunta.opciones.forEachIndexed { index, opcion ->
            Button(
                onClick = {
                    seleccion = index
                    resultado = if (index == pregunta.respuestaCorrecta) {
                        onAnswerCorrect()
                        "✅ Correcto"
                    } else {
                        "❌ Incorrecto"
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .clip(RoundedCornerShape(8.dp)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (seleccion == index) {
                        if (index == pregunta.respuestaCorrecta) Color(0xFF4CAF50) else Color(0xFFE53935)
                    } else MaterialTheme.colorScheme.primary
                )
            ) {
                Text(opcion)
            }
        }

        if (resultado.isNotEmpty()) {
            Text(
                text = resultado,
                style = MaterialTheme.typography.bodyLarge,
                color = if (resultado.contains("Correcto")) Color(0xFF4CAF50) else Color(0xFFE53935),
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

// ✅ **Función para obtener preguntas**
fun obtenerPreguntasPorTema(tema: String): List<Pregunta> {
    return when (tema) {
        "Procesador" -> listOf(
            Pregunta(
                texto = "¿Qué hace un procesador?",
                opciones = listOf("Ejecuta instrucciones", "Almacena datos", "Dibuja gráficos", "Maneja la red"),
                respuestaCorrecta = 0
            ),
            Pregunta(
                texto = "¿Qué parte del procesador realiza los cálculos matemáticos?",
                opciones = listOf("ALU", "Unidad de Control", "Registros", "Caché"),
                respuestaCorrecta = 0
            )
        )
        "RAM" -> listOf(
            Pregunta(
                texto = "¿Cuál es la función de la RAM?",
                opciones = listOf("Ejecutar programas", "Almacenar permanentemente", "Procesar gráficos", "Ninguna de las anteriores"),
                respuestaCorrecta = 0
            ),
            Pregunta(
                texto = "¿Qué sucede cuando se apaga la computadora respecto a la RAM?",
                opciones = listOf("Los datos se pierden", "Los datos se guardan permanentemente", "Nada cambia", "Se guarda en el disco duro"),
                respuestaCorrecta = 0
            )
        )
        else -> emptyList()
    }
}

// ✅ **Modelo de datos**
data class PreguntaQuiz(
    val texto: String,
    val opciones: List<String>,
    val respuestaCorrecta: Int
)