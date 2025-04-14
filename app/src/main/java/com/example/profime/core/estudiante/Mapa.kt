package com.example.profime.core.estudiante

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.profime.R
import com.example.profime.core.data.ValidaCapitulo
import com.example.profime.ui.theme.blanco
import com.example.profime.ui.theme.botonverde
import com.example.profime.ui.theme.negro
import com.example.profime.ui.theme.verdefime

@Composable
fun Mapa(navController: NavController){
    Scaffold(
        topBar = { BarraSuperior()},
        bottomBar = { BarraInferior(navController)},
        content= {paddingValues -> ContentMapa(navController, paddingValues) }

    )
}

@Composable
fun ContentMapa(navController: NavController, paddingValues: PaddingValues){
    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .paint(
                    painter = painterResource(id = R.drawable.wallpaperblanco),
                    contentScale = ContentScale.Crop
                )
        ) {
            ToggleImageButton(navController, 1, 0.dp, 90.dp, R.drawable.btnupf1, R.drawable.btndownf1, R.drawable.btnupt1)
            ToggleImageButton(navController, 2, 180.dp, 125.dp, R.drawable.btnupf2, R.drawable.btndownf2, R.drawable.btnupt2)
            ToggleImageButton(navController, 3, 317.dp, 217.dp, R.drawable.btnupf3, R.drawable.btndownf3, R.drawable.btnupt3)
            ToggleImageButton(navController, 4, 191.dp, 348.dp, R.drawable.btnupf4, R.drawable.btndownf4, R.drawable.btnupt4)
            ToggleImageButton(navController, 5, 9.dp, 355.dp, R.drawable.btnupf5, R.drawable.btndownf5, R.drawable.btnupt5)
            ToggleImageButton(navController, 6, 159.dp, 468.dp, R.drawable.btnupf6, R.drawable.btndownf6, R.drawable.btnupt6)
            ToggleImageButton(navController, 7, 320.dp, 441.dp, R.drawable.btnupf7, R.drawable.btndownf7, R.drawable.btnupt7)
            ToggleImageButton(navController, 8, 320.dp, 608.dp, R.drawable.btnupf8, R.drawable.btndownf8, R.drawable.btnupt8)
            ToggleImageButton(navController, 9, 125.dp, 610.dp, R.drawable.btnupf9, R.drawable.btndownf9, R.drawable.btnupt9)
            ToggleImageButton(navController, 10, 10.dp, 710.dp, R.drawable.btnupf10, R.drawable.btndownf10, R.drawable.btnupt10)

            /*Button(onClick = { /*TODO*/ },
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
            }*/

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

@Composable
fun ToggleImageButton(navController: NavController,capitulo: Int,xoffset: Dp, yoffset: Dp, iconup: Int,icondown: Int, iconhecho: Int) {
    var isPressed by remember { mutableStateOf(false) } // Estado para detectar si está presionado
    var clickboton by remember { mutableStateOf(false) }
    Image(
        painter = painterResource(id = if (isPressed) icondown else iconup),
        contentDescription = "Botón de imagen",
        modifier = Modifier
            .size(110.dp)
            .offset(x = xoffset, y = yoffset)
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {isPressed = true  // Cambia la imagen al presionar
                        tryAwaitRelease() // Espera hasta que se suelte
                        isPressed = false // Regresa a la imagen original al soltar
                        clickboton = true
                    }
                )
            }
    )
    if (clickboton){
        ValidaCapitulo(navController, capitulo)
        clickboton = false
    }
}