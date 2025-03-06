package com.example.profime.core.common

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.profime.ui.theme.blanco
import com.example.profime.ui.theme.negro
import com.example.profime.ui.theme.verdechillon

@Composable
fun Dialogo(titulo: String, mensaje: String, mostrar: Boolean, onDismiss: () -> Unit, onConfirm: () -> Unit){
    if (mostrar){
        AlertDialog(
            onDismissRequest = {onDismiss()},
            title = { Text(text = titulo)},
            text = { Text(text = mensaje)},
            confirmButton = {
                TextButton(onClick = {onConfirm()}) {
                    Text(text = "Aceptar")
                }
            },
            dismissButton = {
                TextButton(onClick = {onDismiss()}) {
                    Text(text = "Cancelar")
                }
            }
        )
    }
}

@Composable
fun Mensaje(mensaje: String){
    val context= LocalContext.current
    Toast.makeText(context, mensaje, Toast.LENGTH_LONG).show()
}

@Composable
fun BarraProgreso(
    modifier: Modifier = Modifier,
    progress: Float,
    height: Int = 30,
    clipShape: Shape = RoundedCornerShape(16.dp)
) {
    Box(
        modifier = modifier
            .clip(clipShape)
            .background(color = negro)
            .height(height.dp)
    ) {
        Box(modifier = Modifier
            .background(color = verdechillon)
            .fillMaxHeight()
            .fillMaxWidth(progress)
        )
        {
            Text(text = (progress * 100).toInt().toString() + "%")
        }
    }
}