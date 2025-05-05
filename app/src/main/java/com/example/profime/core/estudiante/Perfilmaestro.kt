package com.example.profime.core.estudiante

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.profime.R

@Composable
fun MaestroProfile(navController: NavController) {
    Scaffold(
        topBar = { BarraSuperior() }, // Barra superior
        bottomBar = { BarraInferior(navController) }, // Barra inferior
        content = { paddingValues ->
            ContentMaestroProfile(navController, paddingValues)
        }
    )
}

@Composable
fun ContentMaestroProfile(navController: NavController, paddingValues: PaddingValues) {
    var maestroName by remember { mutableStateOf("Juan Pérez") }
    var maestroEmail by remember { mutableStateOf("juan.perez@profime.com") }
    var maestroRole by remember { mutableStateOf("Maestro") }

    var isEditingName by remember { mutableStateOf(false) }
    var isEditingEmail by remember { mutableStateOf(false) }
    var isEditingRole by remember { mutableStateOf(false) }

    val profileImage = R.drawable.osomaestro

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE3F2FD)) // Fondo suave
            .padding(paddingValues)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Imagen de perfil
            Image(
                painter = painterResource(id = profileImage),
                contentDescription = "Foto de perfil",
                modifier = Modifier
                    .size(140.dp)
                    .clip(CircleShape)
                    .border(4.dp, Color.White, CircleShape)
                    .background(Color.Gray.copy(alpha = 0.1f)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Tarjeta del perfil
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(6.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    PerfilEditable("Nombre", maestroName, isEditingName,
                        onValueChange = { maestroName = it },
                        onEditToggle = { isEditingName = !isEditingName }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    PerfilEditable("Correo Electrónico", maestroEmail, isEditingEmail,
                        onValueChange = { maestroEmail = it },
                        onEditToggle = { isEditingEmail = !isEditingEmail }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    PerfilEditable("Rol", maestroRole, isEditingRole,
                        onValueChange = { maestroRole = it },
                        onEditToggle = { isEditingRole = !isEditingRole }
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Botón Guardar
            Button(
                onClick = {
                    // Acción para guardar los cambios
                    isEditingName = false
                    isEditingEmail = false
                    isEditingRole = false
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1976D2)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Guardar Cambios", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Botón Cerrar Sesión
            OutlinedButton(
                onClick = {
                    navController.navigate("login") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                border = BorderStroke(1.5.dp, Color(0xFFB71C1C)),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFB71C1C)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Cerrar Sesión", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerfilEditable(
    label: String,
    valor: String,
    isEditing: Boolean,
    onValueChange: (String) -> Unit,
    onEditToggle: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        if (isEditing) {
            OutlinedTextField(
                value = valor,
                onValueChange = onValueChange,
                label = { Text(label) },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF1976D2),
                    unfocusedBorderColor = Color.Gray
                )
            )
        } else {
            Column(modifier = Modifier.weight(1f)) {
                Text(label, fontSize = 13.sp, color = Color.Gray)
                Text(valor, fontSize = 16.sp, fontWeight = FontWeight.Medium)
            }
            IconButton(onClick = onEditToggle) {
                Icon(painter = painterResource(id = R.drawable.editar), contentDescription = "Editar")
            }
        }
    }
}