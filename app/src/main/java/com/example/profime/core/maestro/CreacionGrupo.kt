package com.example.profime.core.estudiante

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder

@Composable
fun CreacionGrupo(navController: NavController) { // Recibe el NavController
    Scaffold(
        topBar = { BarraSuperior() },
        bottomBar = { BarraInferior() }
    ) { paddingValues ->
        ContentCreacionGrupo(paddingValues) // ✅ Ahora sí llama al contenido correcto
    }}

@Composable
fun ContentCreacionGrupo(paddingValues: PaddingValues) {
    var grupoNombre by remember { mutableStateOf(TextFieldValue("")) }
    var grupoNumero by remember { mutableStateOf(TextFieldValue("")) }
    var qrCodeBitmap by remember { mutableStateOf<Bitmap?>(null) }
    var grupoLink by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(16.dp)
    ) {
        Text("Crear un nuevo grupo", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de texto para ingresar el nombre del grupo
        Text("Nombre del grupo:")
        BasicTextField(
            value = grupoNombre,
            onValueChange = { grupoNombre = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.Gray.copy(alpha = 0.1f))
                .padding(16.dp),
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de texto para ingresar el número del grupo
        Text("Número del grupo:")
        BasicTextField(
            value = grupoNumero,
            onValueChange = { grupoNumero = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.Gray.copy(alpha = 0.1f))
                .padding(16.dp),
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para generar el código QR y el enlace
        Button(
            onClick = {
                if (grupoNombre.text.isNotEmpty() && grupoNumero.text.isNotEmpty()) {
                    // Generar enlace con el nombre del grupo y el número
                    grupoLink = "https://miapp.com/grupo/${grupoNombre.text}/${grupoNumero.text}"

                    // Generar código QR con el enlace
                    val barcodeEncoder = BarcodeEncoder()
                    qrCodeBitmap = barcodeEncoder.encodeBitmap(
                        grupoLink,
                        BarcodeFormat.QR_CODE,
                        400,
                        400
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Generar Código QR")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Mostrar el código QR generado
        qrCodeBitmap?.let {
            Image(
                bitmap = it.asImageBitmap(),
                contentDescription = "Código QR del grupo",
                modifier = Modifier
                    .size(200.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Mostrar el enlace generado
        if (grupoLink.isNotEmpty()) {
            Text(
                text = "Enlace del grupo: $grupoLink",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}