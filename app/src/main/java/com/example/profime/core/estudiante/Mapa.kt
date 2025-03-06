package com.example.profime.core.estudiante

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profime.R

@Composable
fun Mapa(){
    Scaffold(
        topBar = { BarraSuperior()},
        bottomBar = { BarraInferior()},
        content= {paddingValues -> ContentMapa(paddingValues) }

    )
}

@Composable
fun ContentMapa(paddingValues: PaddingValues){
    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .paint(
                    painter = painterResource(id = R.drawable.fondomapa),
                    contentScale = ContentScale.Crop
                )
        ) {
            Button(onClick = { /*TODO*/ },
                modifier = Modifier.size(60.dp).offset(x=5.dp,y=110.dp).clip(CircleShape),
                contentPadding = PaddingValues(0.dp)) {
                Text(text = "1", fontSize = 20.sp)
            }
            Button(onClick = { /*TODO*/ },
                modifier = Modifier.size(60.dp).offset(x=230.dp,y=120.dp).clip(CircleShape),
                contentPadding = PaddingValues(0.dp)) {
                Text(text = "2", fontSize = 20.sp)
            }
            /*
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
                    .padding(top = 100.dp)
            ) {
                item {

                }
            }*/
        }
    }
}