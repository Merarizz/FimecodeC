package com.example.profime.core.estudiante

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.profime.R
import com.example.profime.ui.theme.*

@Composable
fun Mapa(navController: NavController){
    Scaffold(
        topBar = { BarraSuperior() },
        bottomBar = { BarraInferior(navController) },
        content = { ContentMapa(navController) }
    )
}

@Composable
fun ContentMapa(navController: NavController){
    MaterialTheme {
        var osoX by remember { mutableStateOf(100.dp) }
        var osoY by remember { mutableStateOf(220.dp) }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .paint(
                    painter = painterResource(id = R.drawable.wallpaperflechas),
                    contentScale = ContentScale.Crop
                )
        ) {
            // OSO
            Image(
                painter = painterResource(id = R.drawable.osito),
                contentDescription = "oso",
                modifier = Modifier
                    .size(100.dp)
                    .offset(x = osoX, y = osoY)
            )

            // BOTONES DEL MAPA
            ToggleImageButton(navController, 1, 0.dp, 90.dp, R.drawable.btnupf1, R.drawable.btndownf1, R.drawable.btnupt1) {
                osoX = 80.dp; osoY = 110.dp
            }
            ToggleImageButton(navController, 2, 200.dp, 115.dp, R.drawable.btnupf2, R.drawable.btndownf2, R.drawable.btnupt2) {
                osoX = 260.dp; osoY = 155.dp
            }
            ToggleImageButton(navController, 3, 340.dp, 217.dp, R.drawable.btnupf3, R.drawable.btndownf3, R.drawable.btnupt3) {
                osoX = 280.dp; osoY = 217.dp
            }
            ToggleImageButton(navController, 4, 210.dp, 348.dp, R.drawable.btnupf4, R.drawable.btndownf4, R.drawable.btnupt4) {
                osoX = 191.dp; osoY = 280.dp
            }
            ToggleImageButton(navController, 5, 20.dp, 355.dp, R.drawable.btnupf5, R.drawable.btndownf5, R.drawable.btnupt5) {
                osoX = 9.dp; osoY = 270.dp
            }
            ToggleImageButton(navController, 6, 180.dp, 468.dp, R.drawable.btnupf6, R.drawable.btndownf6, R.drawable.btnupt6) {
                osoX = 100.dp; osoY = 468.dp
            }
            ToggleImageButton(navController, 7, 350.dp, 441.dp, R.drawable.btnupf7, R.drawable.btndownf7, R.drawable.btnupt7) {
                osoX = 280.dp; osoY = 480.dp
            }
            ToggleImageButton(navController, 8, 350.dp, 608.dp, R.drawable.btnupf8, R.drawable.btndownf8, R.drawable.btnupt8) {
                osoX = 280.dp; osoY = 608.dp
            }
            ToggleImageButton(navController, 9, 140.dp, 640.dp, R.drawable.btnupf9, R.drawable.btndownf9, R.drawable.btnupt9) {
                osoX = 125.dp; osoY = 570.dp
            }
            ToggleImageButton(navController, 10, 10.dp, 710.dp, R.drawable.btnupf10, R.drawable.btndownf10, R.drawable.btnupt10) {
                osoX = 10.dp; osoY = 630.dp
            }
            ToggleImageButton(navController, 11, 150.dp, 720.dp, R.drawable.huella2, R.drawable.huella1, R.drawable.huella1) {
                osoX = 150.dp; osoY = 720.dp
            }
        }
    }
}

@Composable
fun ToggleImageButton(
    navController: NavController,
    capitulo: Int,
    xoffset: Dp,
    yoffset: Dp,
    iconup: Int,
    icondown: Int,
    iconhecho: Int,
    onClick: () -> Unit // Nueva acción para mover el oso
) {
    var isPressed by remember { mutableStateOf(false) }

    Image(
        painter = painterResource(id = if (isPressed) icondown else iconup),
        contentDescription = "Botón de imagen",
        modifier = Modifier
            .size(110.dp)
            .offset(x = xoffset, y = yoffset)
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        isPressed = true
                        tryAwaitRelease()
                        isPressed = false
                        onClick() // Se mueve el oso
                    }
                )
            }
    )
}