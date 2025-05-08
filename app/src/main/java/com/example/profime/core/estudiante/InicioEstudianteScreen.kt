package com.example.profime.core.estudiante

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.profime.core.data.*
// 📌 Modelo de datos
data class Curso(val nombre: String, val progreso: Float)
data class Examen(val titulo: String, val fecha: String)


@Composable
fun InicioEstudianteScreen(navController: NavController, estudiante: Estudiante) {
    Scaffold(
        topBar = { BarraSuperior() },
        bottomBar = { BarraInferioralu(navController) }
    ) { paddingValues ->
        ContentInicioEstudianteScreen(navController, estudiante, paddingValues)
    }
}

@Composable
fun ContentInicioEstudianteScreen(navController: NavController, estudiante: Estudiante, paddingValues: PaddingValues) {
    val cursos = listOf(
        Curso("Procesador", 0.8f),
        Curso("RAM", 0.5f),
        Curso("Punteros y Memoria", 0.2f)
    )

    val examenes = listOf(
        Examen("Examen de Variables", "10 Abril"),
        Examen("Examen de Bucles", "15 Abril"),
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {

            Spacer(modifier = Modifier.height(16.dp))
            Text("Bienvenido, ${estudiante.nombre} 👋", style = MaterialTheme.typography.headlineSmall)
        }

        item { CardInfo("Grupo", estudiante.id_grupo.toString()) }
        item {
            Button(
                onClick = { navController.navigate("qrScanner") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text("📷 Ingresa nuevo grupo")
            }
        }
        item { Text("📚 Tus cursos", style = MaterialTheme.typography.titleMedium) }
        items(cursos) { curso -> CardCurso(navController, curso) }
        item { Text("📚 Tus cursos", style = MaterialTheme.typography.titleMedium) }

        item {
            Button(
                onClick = {
                    navController.navigate("mapa")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text("Ir al Mapa del Curso")
            }
        }

        items(cursos) { curso -> CardCurso(navController, curso) }

        item { Text("📝 Próximos exámenes", style = MaterialTheme.typography.titleMedium) }
        items(examenes) { examen -> CardExamen(examen) }

        item { Text("👤 Tu información", style = MaterialTheme.typography.titleMedium) }
        item { CardInfo("Número de estudiante", estudiante.id_estudiante.toString()) }
        item { CardInfo("Correo", estudiante.correo) }

    }
}

// 📌 **Tarjeta de Curso con Navegación**
@Composable
fun CardCurso(navController: NavController, curso: Curso) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable {
                navController.navigate("preguntaScreen/${curso.nombre}") // 🔥 Navega a la pantalla de preguntas con el tema
            }
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(curso.nombre, style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            LinearProgressIndicator(progress = curso.progreso, modifier = Modifier.fillMaxWidth())
            Text("Progreso: ${(curso.progreso * 100).toInt()}%", style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Composable
fun CardExamen(examen: Examen) {
    Card(modifier = Modifier.fillMaxWidth().padding(4.dp)) {
        Column(Modifier.padding(16.dp)) {
            Text(examen.titulo, style = MaterialTheme.typography.bodyLarge)
            Text("Fecha: ${examen.fecha}", color = MaterialTheme.colorScheme.secondary)
        }
    }
}

@Composable
fun CardInfo(label: String, value: String) {
    Card(modifier = Modifier.fillMaxWidth().padding(4.dp)) {
        Column(Modifier.padding(16.dp)) {
            Text(label, style = MaterialTheme.typography.bodySmall)
            Text(value, style = MaterialTheme.typography.bodyLarge)
        }
    }
}