package com.example.profime

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.profime.core.data.ValidaUsuario
import com.example.profime.ui.theme.blanco
import com.example.profime.ui.theme.botonverde
import com.example.profime.ui.theme.grisinactivo
import com.example.profime.ui.theme.negro
import com.example.profime.ui.theme.verdefime


@Composable
fun InicioSesion(navController: NavController) {
    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .paint(
                    painter = painterResource(id = R.drawable.fondoapp),
                    contentScale = ContentScale.Crop // Evita que el fondo se estire
                )
        ) {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    ElevatedCard(
                        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                        modifier = Modifier
                            .size(width = 380.dp, height = 710.dp)
                            .padding(top = 150.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 5.dp),
                                painter = painterResource(id = R.drawable.fondouanl),
                                contentDescription = "Logotipo de FIME"
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            UsuarioSesion(navController)
                        }
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsuarioSesion(navController: NavController) {
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(0) }
    val items = listOf("Estudiantes", "Profesores")
    val habilitado = true
    var clickboton by remember { mutableStateOf(false) }


    /*botones alumno y  maestro*/

    SingleChoiceSegmentedButtonRow {
        items.forEachIndexed { index, item ->
            SegmentedButton(
                shape = SegmentedButtonDefaults.itemShape(
                    index = index,
                    count = items.size
                ),
                onClick = { selectedIndex = index },
                selected = selectedIndex == index,
                label = { Text(text = item) },
                colors = SegmentedButtonDefaults.colors(
                    activeContainerColor = verdefime,
                    inactiveContainerColor = grisinactivo,
                    activeContentColor = blanco,
                    inactiveContentColor = negro
                )
            )
        }
    }

    /*usuario y contra*/
    Spacer(modifier = Modifier.height(16.dp))
    OutlinedTextField(  // USUARIO
        value = user,
        onValueChange = { user = it },
        label = { Text(text = "Matrícula") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = verdefime,
            unfocusedBorderColor = grisinactivo,
            cursorColor = negro
        ),
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(16.dp))
    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = { Text(text = "Contraseña") },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconToggleButton(
                checked = passwordVisible,
                onCheckedChange = { passwordVisible = it }
            ) {
                Icon(
                    imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                    contentDescription = if (passwordVisible) "Ocultar contraseña" else "Mostrar contraseña"
                )
            }
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = verdefime,
            unfocusedBorderColor = grisinactivo,
            cursorColor = negro
        ),
        modifier = Modifier.fillMaxWidth()
    )

    /*recuperación*/

    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = stringResource(id = R.string.olvidaste_contraseña),
        style = MaterialTheme.typography.bodyMedium,
        color = negro,
        modifier = Modifier.padding(bottom = 8.dp)
    )

    Button(
        onClick = { clickboton = true },
        colors = ButtonDefaults.buttonColors(
            containerColor = botonverde,
            contentColor = blanco
        ),
        enabled = habilitado,
        shape = MaterialTheme . shapes . medium,
        modifier = Modifier
            .fillMaxWidth(0.6f)
            .height(50.dp)
    ) {
        Text(
            text = "INGRESAR",
            style = MaterialTheme.typography.labelLarge
        )
    }
    if (clickboton) {
        ValidaUsuario(navController, items[selectedIndex], user, password)
        clickboton = false
    }
}





