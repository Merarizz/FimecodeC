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
fun CrearCursoConNavController(navController: NavController) {
    Scaffold(
        topBar = { BarraSuperior() },
        bottomBar = { BarraInferior() }
    ) { paddingValues ->
        CrearCurso(navController, paddingValues) // ✅ Ahora está en el orden correcto
    }
}

@Composable
fun CrearCurso(navController: NavController, paddingValues: PaddingValues) {
    var courseName by remember { mutableStateOf("") }
    var courseDescription by remember { mutableStateOf("") }
    var courseCode by remember { mutableStateOf("") }

    var showQuizForm by remember { mutableStateOf(false) }
    var quizCode by remember { mutableStateOf("") }
    var correctAnswer by remember { mutableStateOf("") }
    var incorrectAnswer by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp) // Aplica padding interno para que no esté pegado a los bordes
            .padding(paddingValues) // Aquí aplicamos el padding recibido del Scaffold
    ) {
        // Título
        Text(
            "Crear Curso",
            fontSize = 24.sp, // Tamaño de fuente
            fontWeight = FontWeight.Bold, // Peso de la fuente
            color = MaterialTheme.colorScheme.primary, // Color de la fuente
            modifier = Modifier.padding(bottom = 16.dp) // Espaciado opcional
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Formulario de curso
        OutlinedTextField(
            value = courseName,
            onValueChange = { courseName = it },
            label = { Text("Nombre del Curso") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = courseDescription,
            onValueChange = { courseDescription = it },
            label = { Text("Descripción del Curso") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = courseCode,
            onValueChange = { courseCode = it },
            label = { Text("Código del Curso") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { showQuizForm = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Agregar Quiz")
        }

        // Formulario para el quiz
        if (showQuizForm) {
            Spacer(modifier = Modifier.height(16.dp))

            Text("Agregar Pregunta de Quiz")

            OutlinedTextField(
                value = quizCode,
                onValueChange = { quizCode = it },
                label = { Text("Código para el Quiz") },
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
                    // Aquí agregarías la lógica para guardar el curso y quiz en la base de datos
                    showQuizForm = false
                    // Navegar de vuelta a la pantalla anterior
                    navController.popBackStack()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Guardar Curso y Quiz")
            }
        }
    }
}