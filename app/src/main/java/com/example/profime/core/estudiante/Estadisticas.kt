package com.example.profime.core.estudiante

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profime.R
import com.example.profime.ui.theme.azulclaro
import com.example.profime.ui.theme.blanco
import com.example.profime.ui.theme.botonverde
import com.example.profime.ui.theme.negro
import com.example.profime.ui.theme.rojorosado
import com.example.profime.ui.theme.verdegris
import com.example.profime.ui.theme.verdehoja
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun Estadisticas() {
    Scaffold(
        topBar = { BarraSuperior() },
        bottomBar = { BarraInferior() },
        content = { paddingValues -> ContentEstadisticas(paddingValues) }
    )
}

@Composable
fun ContentEstadisticas(paddingValues: PaddingValues) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.fondoapp),
                contentScale = ContentScale.Crop
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Podio de Aprendizaje",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = blanco,
                modifier = Modifier.padding(16.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth().background(color = azulclaro),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.Bottom
            ) {
                EstadisticaPodio("Jose", 2, 95, 120.dp)
                EstadisticaPodio("Pedro", 1, 98, 140.dp)
                EstadisticaPodio("Luisa", 3, 93, 110.dp)
            }

            ProgressBar(percentage = 80)

            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(estadisticasDeCapitulos) { estadistica ->
                    EstadisticaCard(estadistica)
                }
            }
        }
    }
}

@Composable
fun EstadisticaPodio(titulo: String, lugar: Int, progreso: Int, altura: Dp) {
    val colores = listOf(
        rojorosado,
        verdehoja,
        verdegris
    )
    Box( modifier = Modifier
        .width(120.dp)
        .height(altura)
        .padding(8.dp),contentAlignment = Alignment.TopCenter){
        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            modifier = Modifier
                .width(120.dp)
                .height(altura)
                .padding(8.dp),
            colors = CardDefaults.cardColors(containerColor = colores[lugar - 1])
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text(text = titulo, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = negro)
                Text(text = "$progreso", fontSize = 22.sp, fontWeight = FontWeight.ExtraBold, color = negro)
            }
        }
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopCenter){
            val image: Painter = painterResource(id =R.drawable.copa)
            Image(painter = image, contentDescription = "Copa", modifier = Modifier.size(45.dp).offset(y=(-20).dp))
        }
    }

}

@Composable
fun ProgressBar(percentage: Int) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Progreso General", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = blanco)
        LinearProgressIndicator(
            progress = percentage / 100f,
            modifier = Modifier.fillMaxWidth().height(20.dp),
            color = botonverde
        )
    }
}

@Composable
fun EstadisticaCard(estadistica: Estadistica) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = azulclaro)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = estadistica.titulo, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = blanco)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Puntaje: ${estadistica.puntaje}", color = blanco)
            Text(text = "Tiempo: ${estadistica.tiempo} minutos", color = blanco)
        }
    }
}

// Clase de datos Estadistica
data class Estadistica(val titulo: String, val puntaje: Int, val tiempo: Int)

// Lista de ejemplo
val estadisticasDeCapitulos = listOf(
    Estadistica("Capítulo 1", 85, 30),
    Estadistica("Capítulo 2", 90, 25),
    Estadistica("Capítulo 3", 78, 40)
)
