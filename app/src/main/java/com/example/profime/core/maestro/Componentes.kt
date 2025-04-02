package com.example.profime.core.estudiante

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.profime.R

@Composable
private fun PerfilUsuarioAdmin() {
    Image(
        painter = painterResource(id = R.drawable.perfil), // Aquí va la imagen de perfil
        contentDescription = "Imagen de perfil",
        modifier = Modifier
            .size(100.dp)
            .padding(8.dp)
    )
}

@Composable
fun ButtonSection(title: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
    ) {
        Text(title, style = MaterialTheme.typography.bodyLarge)
    }
}
