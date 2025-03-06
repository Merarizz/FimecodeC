package com.example.profime.core.estudiante

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.profime.R

@Composable
fun Notificaciones(){
    Scaffold(
        topBar = { BarraSuperior()},
        bottomBar = { BarraInferior()},
        content= {paddingValues -> ContentNotificaciones(paddingValues)}

    )

}

@Composable
fun ContentNotificaciones(paddingValues: PaddingValues) {
    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .paint(
                    painter = painterResource(id = R.drawable.fondoapp),
                    contentScale = ContentScale.Crop
                )
        ) {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
                    .padding(top = 100.dp)
            ) {
                item {
                    Notificacion("Tienes una tarea pendiente", 16)
                    }
                item {
                    Notificacion("Tienes una tarea pendiente", 16)
                }
                item {
                    Notificacion("Tienes una tarea pendiente", 16)
                }
            }
        }
    }
}

@Composable
fun Notificacion(Texto: String, ptop:Int){
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .size(width = 380.dp, height = 150.dp)
            .padding(top = ptop.dp)
    ) {
        LazyRow(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
            //horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp, start = 10.dp),
                    painter = painterResource(id = R.drawable.portadacpp),
                    contentDescription = "Logotipo de FIME"
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = Texto,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }
    }
}
