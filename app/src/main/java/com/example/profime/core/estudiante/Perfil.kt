package com.example.profime.core.estudiante

import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.profime.R
import com.example.profime.ui.theme.blanco
import com.example.profime.ui.theme.botonverde
import com.example.profime.ui.theme.grisinactivo
import com.example.profime.ui.theme.negro
import com.example.profime.ui.theme.verdefime

@Composable
fun Registro(navController: NavController) { // 📌 Cambié de "Perfil" a "Registro"
    Scaffold(
        topBar = { BarraSuperior() },
        bottomBar = { BarraInferior(navController) },
        content = { paddingValues -> ContentRegistro(paddingValues) }
    )
}

@Composable
fun ContentRegistro(paddingValues: PaddingValues) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        contentAlignment = Alignment.Center
    ) {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier.size(100.dp),
                    painter = painterResource(id = R.drawable.logofime),
                    contentDescription = "Logotipo de FIME"
                )
                Spacer(modifier = Modifier.height(16.dp))
                Formulario()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Formulario() {
    var nombre by remember { mutableStateOf("") }
    var apellidoPaterno by remember { mutableStateOf("") }
    var apellidoMaterno by remember { mutableStateOf("") }
    var matricula by remember { mutableStateOf("") }
    var carrera by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    // 📌 VALIDACIONES
    val correoValido = remember(correo) { Patterns.EMAIL_ADDRESS.matcher(correo).matches() }
    val matriculaValida = remember(matricula) { matricula.all { it.isDigit() } && matricula.isNotEmpty() }
    val habilitado = nombre.isNotEmpty() && apellidoPaterno.isNotEmpty() &&
            apellidoMaterno.isNotEmpty() && matriculaValida &&
            carrera.isNotEmpty() && correoValido && password.isNotEmpty()

    Column(modifier = Modifier.fillMaxWidth()) {
        CustomTextField(value = nombre, label = "Nombre") { nombre = it }
        CustomTextField(value = apellidoPaterno, label = "Apellido Paterno") { apellidoPaterno = it }
        CustomTextField(value = apellidoMaterno, label = "Apellido Materno") { apellidoMaterno = it }

        // 📌 Matrícula (Solo números)
        CustomTextField(
            value = matricula,
            label = "Matrícula",
            keyboardType = KeyboardType.Number,
            isValid = matriculaValida,
            errorMessage = "Solo se permiten números"
        ) { matricula = it }

        CustomTextField(value = carrera, label = "Carrera") { carrera = it }

        // 📌 Correo (Validación)
        CustomTextField(
            value = correo,
            label = "Correo",
            keyboardType = KeyboardType.Email,
            isValid = correoValido,
            errorMessage = "Correo inválido"
        ) { correo = it }

        // 📌 Contraseña
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

        Spacer(modifier = Modifier.height(24.dp))

        // 📌 Botón Aceptar (Deshabilitado si hay errores)
        Button(
            onClick = { /* Aquí iría la acción de registro */ },
            colors = ButtonDefaults.buttonColors(
                containerColor = botonverde,
                contentColor = blanco
            ),
            enabled = habilitado,
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(text = "Aceptar", style = MaterialTheme.typography.labelLarge)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    value: String,
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    isValid: Boolean = true,
    errorMessage: String = "",
    onValueChange: (String) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(text = label) },
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            isError = !isValid,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = if (isValid) verdefime else MaterialTheme.colorScheme.error,
                unfocusedBorderColor = grisinactivo,
                cursorColor = negro
            ),
            modifier = Modifier.fillMaxWidth()
        )
        if (!isValid) {
            Text(text = errorMessage, color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodySmall)
        }
    }
}