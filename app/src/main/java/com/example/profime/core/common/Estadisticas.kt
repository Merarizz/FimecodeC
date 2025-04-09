package com.example.profime.core.estudiante

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.profime.R

@Composable
fun Estadisticas(navController: NavController) {
    Scaffold(
        topBar = { BarraSuperior() },
        bottomBar = { BarraInferior(navController) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Progreso General",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(12.dp))

            CircularProgressBar(progress = 0.78f) // 🔹 78% de progreso

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Ranking de Aprendizaje",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                EstadisticaPodio("José", R.drawable.copa2, 95)
                EstadisticaPodio("Pedro", R.drawable.copa1, 98)
                EstadisticaPodio("Luisa", R.drawable.copa3, 93)
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Estadísticas por Capítulo",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(start = 16.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f) // 🔹 Esto permite que la lista ocupe solo el espacio necesario y sea deslizable
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                ) {
                    items(estadisticasDeCapitulos) { estadistica ->
                        EstadisticaCard(estadistica)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun CircularProgressBar(progress: Float) {
    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(120.dp) // 🔹 Tamaño ajustado
    ) {
        Canvas(modifier = Modifier.size(120.dp)) {
            val stroke = Stroke(10.dp.toPx(), cap = StrokeCap.Round)

            drawArc(
                color = Color.LightGray,
                startAngle = 270f,
                sweepAngle = 360f,
                useCenter = false,
                style = stroke
            )

            drawArc(
                color = Color(0xFF4CAF50),
                startAngle = 270f,
                sweepAngle = 360f * animatedProgress,
                useCenter = false,
                style = stroke
            )
        }

        Text(
            text = "${(animatedProgress * 100).toInt()}%",
            fontSize = 18.sp, // 🔹 Tamaño ajustado para mejor legibilidad
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}

@Composable
fun EstadisticaPodio(nombre: String, imagenRes: Int, puntaje: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imagenRes),
            contentDescription = "Trofeo",
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = nombre,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Text(
            text = "$puntaje pts",
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun EstadisticaCard(estadistica: Estadistica) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE3F2FD))
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = estadistica.titulo,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Puntaje: ${estadistica.puntaje}", color = Color.Black)
            Text(text = "Tiempo: ${estadistica.tiempo} min", color = Color.Black)

            Spacer(modifier = Modifier.height(8.dp))

            LinearProgressIndicator(
                progress = estadistica.puntaje / 100f,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp),
                color = Color(0xFF4CAF50),
                trackColor = Color.LightGray
            )
        }
    }
}

// Datos de ejemplo
data class Estadistica(val titulo: String, val puntaje: Int, val tiempo: Int)

val estadisticasDeCapitulos = listOf(
    Estadistica("Capítulo 1", 85, 30),
    Estadistica("Capítulo 2", 90, 25),
    Estadistica("Capítulo 3", 78, 40),
    Estadistica("Capítulo 4", 95, 20),
    Estadistica("Capítulo 5", 88, 35)
)