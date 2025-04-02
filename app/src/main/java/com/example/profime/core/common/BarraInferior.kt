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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.profime.core.navigation.Screens
import com.example.profime.ui.theme.azul
import com.example.profime.ui.theme.verdehoja
import com.example.profime.ui.theme.verdeverde

@Composable
fun BarraInferior() {
    val navigationController = rememberNavController()
    val context = LocalContext.current
    BottomAppBar(
        containerColor = verdeverde,
        modifier = Modifier.height(70.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(
                onClick = { navigationController.navigate(Screens.InicioEstudiante.route) },
                modifier = Modifier.weight(1f).padding(top=5.dp)
            ) {
                val image: Painter = painterResource(id = com.example.profime.R.drawable.irinicio_opcion2)
                Image(painter = image, contentDescription = "Inicio", modifier = Modifier.size(45.dp))
            }

            IconButton(
                onClick = { /* Acción del segundo botón */ },
                modifier = Modifier.weight(1f).padding(top=5.dp)
            ) {
                val image: Painter = painterResource(id = com.example.profime.R.drawable.notis_opcion2)
                Image(painter = image, contentDescription = "Notificaciones", modifier = Modifier.size(45.dp))
            }

            IconButton(
                onClick = { /* Acción del tercer botón */ },
                modifier = Modifier.weight(1f).padding(top=5.dp)
            ) {
                val image: Painter = painterResource(id = com.example.profime.R.drawable.estadisticas_opcion2)
                Image(painter = image, contentDescription = "Estadisticas", modifier = Modifier.size(45.dp))
            }

            IconButton(
                onClick = { /* Acción del cuarto botón */ },
                modifier = Modifier.weight(1f).padding(top=5.dp)
            ) {
                val image: Painter = painterResource(id = com.example.profime.R.drawable.perfil)
                Image(painter = image, contentDescription = "perfil", modifier = Modifier.size(45.dp))
            }
        }
    }
}
