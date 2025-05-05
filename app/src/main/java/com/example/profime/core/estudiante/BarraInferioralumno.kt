package com.example.profime.core.estudiante

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.profime.R
import com.example.profime.ui.theme.azul

@Composable
fun BarraInferioralu(navController: NavController) {
    BottomAppBar(
        containerColor =  Color(0xFF1E88E5),
        modifier = Modifier
            .height(60.dp)
            .padding(0.dp)
            .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Icono de Inicio
            IconButton(onClick = { navController.navigate("home") }) {
                Image(painter = painterResource(id = R.drawable.irinicio_opcion2), contentDescription = "Inicio")
            }
            // Icono de Notificaciones
            IconButton(onClick = { navController.navigate("notificaciones") }) {
                Image(painter = painterResource(id = R.drawable.notis_opcion2), contentDescription = "Notificaciones")
            }
            // Icono de Estadísticas
            IconButton(onClick = { navController.navigate("estadisticasalu") }) {
                Image(painter = painterResource(id = R.drawable.estadisticas_opcion2), contentDescription = "Estadísticas")
            }
            // Icono de Perfil
            IconButton(onClick = { navController.navigate("perfil") }) {
                Image(painter = painterResource(id = R.drawable.perfil), contentDescription = "Perfil")
            }
        }
    }
}