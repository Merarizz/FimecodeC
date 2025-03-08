package com.example.profime.core.estudiante

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profime.R
import com.example.profime.ui.theme.blanco
import com.example.profime.ui.theme.botonverde
import com.example.profime.ui.theme.negro
import com.example.profime.ui.theme.verdefime

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
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black    //arreglar colores
                )
            ) {
                Text(text = "1", fontSize = 20.sp)
            }
            Button(onClick = { /*TODO*/ },
                modifier = Modifier.size(60.dp).offset(x=180.dp,y=125.dp).clip(CircleShape),
                contentPadding = PaddingValues(0.dp)) {
                Text(text = "2", fontSize = 20.sp)
            }
            Button(onClick = { /*TODO*/ },
                modifier = Modifier.size(60.dp).offset(x=317.dp,y=217.dp).clip(CircleShape),
                contentPadding = PaddingValues(0.dp)) {
                Text(text = "3", fontSize = 20.sp)
            }
            Button(onClick = { /*TODO*/ },
                modifier = Modifier.size(60.dp).offset(x=191.dp,y=348.dp).clip(CircleShape),
                contentPadding = PaddingValues(0.dp)) {
                Text(text = "4", fontSize = 20.sp)
            }
            Button(onClick = { /*TODO*/ },
                modifier = Modifier.size(60.dp).offset(x=9.dp,y=355.dp).clip(CircleShape),
                contentPadding = PaddingValues(0.dp)) {
                Text(text = "5", fontSize = 20.sp)
            }
            Button(onClick = { /*TODO*/ },
                modifier = Modifier.size(60.dp).offset(x=159.dp,y=468.dp).clip(CircleShape),
                contentPadding = PaddingValues(0.dp)) {
                Text(text = "6", fontSize = 20.sp)
            }
            Button(onClick = { /*TODO*/ },
                modifier = Modifier.size(60.dp).offset(x=336.dp,y=441.dp).clip(CircleShape),
                contentPadding = PaddingValues(0.dp)) {
                Text(text = "7", fontSize = 20.sp)
            }
            Button(onClick = { /*TODO*/ },
                modifier = Modifier.size(60.dp).offset(x=335.dp,y=608.dp).clip(CircleShape),
                contentPadding = PaddingValues(0.dp)) {
                Text(text = "8", fontSize = 20.sp)
            }
            Button(onClick = { /*TODO*/ },
                modifier = Modifier.size(60.dp).offset(x=150.dp,y=590.dp).clip(CircleShape),
                contentPadding = PaddingValues(0.dp)) {
                Text(text = "9", fontSize = 20.sp)
            }
            Button(onClick = { /*TODO*/ },
                modifier = Modifier.size(60.dp).offset(x=10.dp,y=710.dp).clip(CircleShape),
                contentPadding = PaddingValues(0.dp)) {
                Text(text = "10", fontSize = 20.sp)
            }

            Button(onClick = { /*TODO*/ },
                modifier = Modifier.size(100.dp).offset(x=200.dp,y=697.dp).clip(CircleShape),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                )
            ) {
                Text(text = "META", fontSize = 20.sp)
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