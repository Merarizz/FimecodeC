package com.example.profime.core.estudiante

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.profime.ui.theme.azul
import com.example.profime.ui.theme.verdehoja

@Composable
fun BarraInferior() {
    BottomAppBar(
        containerColor = azul,
        modifier = Modifier.height(70.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(
                onClick = { /* Acción del primer botón */ },
                modifier = Modifier.weight(1f).padding(top=5.dp)
            ) {
                val image: Painter = painterResource(id = com.example.profime.R.drawable.irinicio_opcion2)
                Image(painter = image, contentDescription = "Icono 1", modifier = Modifier.size(45.dp))
            }

            IconButton(
                onClick = { /* Acción del segundo botón */ },
                modifier = Modifier.weight(1f).padding(top=5.dp)
            ) {
                val image: Painter = painterResource(id = com.example.profime.R.drawable.notis_opcion2)
                Image(painter = image, contentDescription = "Icono 2", modifier = Modifier.size(45.dp))
            }

            IconButton(
                onClick = { /* Acción del tercer botón */ },
                modifier = Modifier.weight(1f).padding(top=5.dp)
            ) {
                val image: Painter = painterResource(id = com.example.profime.R.drawable.estadisticas_opcion2)
                Image(painter = image, contentDescription = "Icono 3", modifier = Modifier.size(45.dp))
            }

            IconButton(
                onClick = { /* Acción del cuarto botón */ },
                modifier = Modifier.weight(1f).padding(top=5.dp)
            ) {
                val image: Painter = painterResource(id = com.example.profime.R.drawable.perfil)
                Image(painter = image, contentDescription = "Icono 4", modifier = Modifier.size(45.dp))
            }
        }
    }
}
