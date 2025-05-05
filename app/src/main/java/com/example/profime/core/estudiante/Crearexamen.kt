package com.example.profime.core.estudiante

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun CrearExamenConNavController(navController: NavController) { // Recibe el NavController
    Scaffold(
        topBar = { BarraSuperior() },
        bottomBar = { BarraInferior(navController) }
    ) { paddingValues ->
        CrearExamen(navController, paddingValues) // Ahora pasamos navController
    }
}

@Composable
fun CrearExamen(navController: NavController, paddingValues: PaddingValues) {
    var examName by remember { mutableStateOf("") }
    var examDescription by remember { mutableStateOf("") }
    var examCode by remember { mutableStateOf("") }

    var showQuestionForm by remember { mutableStateOf(false) }
    var questionText by remember { mutableStateOf("") }
    var correctAnswer by remember { mutableStateOf("") }
    var incorrectAnswer by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(16.dp)
    ) {
        // Título
        Text(
            "Crear Examen",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Formulario de examen
        OutlinedTextField(
            value = examName,
            onValueChange = { examName = it },
            label = { Text("Nombre del Examen") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = examDescription,
            onValueChange = { examDescription = it },
            label = { Text("Descripción del Examen") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = examCode,
            onValueChange = { examCode = it },
            label = { Text("Código del Examen") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { showQuestionForm = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Agregar Pregunta")
        }

        // Formulario de preguntas
        if (showQuestionForm) {
            Spacer(modifier = Modifier.height(16.dp))

            Text("Agregar Pregunta al Examen")

            OutlinedTextField(
                value = questionText,
                onValueChange = { questionText = it },
                label = { Text("Pregunta") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = correctAnswer,
                onValueChange = { correctAnswer = it },
                label = { Text("Respuesta Correcta") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = incorrectAnswer,
                onValueChange = { incorrectAnswer = it },
                label = { Text("Respuesta Incorrecta") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    // Aquí agregarías la lógica para guardar el examen y sus preguntas en la base de datos
                    showQuestionForm = false
                    navController.popBackStack() // Regresa a la pantalla anterior
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Guardar Examen")
            }
        }
    }
}