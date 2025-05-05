package com.example.profime.core.estudiante

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.profime.R

@Composable
fun BarraInferiorMaestro(navController: NavController) {
    BottomAppBar(
        containerColor = Color(0xFF1E88E5), // Color azul de la barra
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
            // 🔹 Inicio
            IconButton(onClick = { navController.navigate("administradorMaestro") }) {
                Image(painter = painterResource(id = R.drawable.irinicio_opcion2), contentDescription = "Inicio")
            }
            // 🔹 Notificaciones
            IconButton(onClick = { navController.navigate("notificacionesMaestro") }) {
                Image(painter = painterResource(id = R.drawable.notis_opcion2), contentDescription = "Notificaciones")
            }
            // 🔹 Estadísticas
            IconButton(onClick = { navController.navigate("estadisticasMaestro") }) {
                Image(painter = painterResource(id = R.drawable.estadisticas_opcion2), contentDescription = "Estadísticas")
            }
            // 🔹 Perfil
            IconButton(onClick = { navController.navigate("perfilMaestro") }) {
                Image(painter = painterResource(id = R.drawable.perfil), contentDescription = "Perfil")
            }
        }
    }
}