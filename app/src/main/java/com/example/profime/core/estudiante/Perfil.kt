package com.example.profime.core.estudiante


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.profime.R
import com.example.profime.UsuarioSesion
import com.example.profime.core.common.BarraProgreso
import com.example.profime.ui.theme.blanco
import com.example.profime.ui.theme.botonverde
import com.example.profime.ui.theme.grisinactivo
import com.example.profime.ui.theme.negro
import com.example.profime.ui.theme.verdefime

@Composable
fun Perfil(navController: NavController){
    Scaffold(
        topBar = { BarraSuperior()},
        bottomBar = { BarraInferior(navController)},
        content= {paddingValues -> ContentPerfil(navController, paddingValues)}

    )
}

@Composable
fun ContentPerfil(navController: NavController, paddingValues: PaddingValues){
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
                            .size(width = 380.dp, height = 750.dp)
                            .padding(top = 150.dp)
                    ) {
                        LazyColumn (
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            item {
                                Image(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 5.dp),
                                    painter = painterResource(id = R.drawable.logofime),
                                    contentDescription = "Logotipo de FIME"
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                            }
                            item{
                                Formulario()
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Formulario() {
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(0) }
    val items = listOf("Estudiantes", "Profesores")
    val habilitado = true


    /*cajas de texto*/
    Spacer(modifier = Modifier.height(16.dp))
    OutlinedTextField(
        value = user,
        onValueChange = { user = it },
        label = { Text(text = "Nombre") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = verdefime,
            unfocusedBorderColor = grisinactivo,
            cursorColor = negro
        ),
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(16.dp))
    OutlinedTextField(
        value = user,
        onValueChange = { user = it },
        label = { Text(text = "Apellido paterno") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = verdefime,
            unfocusedBorderColor = grisinactivo,
            cursorColor = negro
        ),
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(16.dp))
    OutlinedTextField(
        value = user,
        onValueChange = { user = it },
        label = { Text(text = "Apellido materno") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = verdefime,
            unfocusedBorderColor = grisinactivo,
            cursorColor = negro
        ),
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(16.dp))
    OutlinedTextField(
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
        value = user,
        onValueChange = { user = it },
        label = { Text(text = "Carrera") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = verdefime,
            unfocusedBorderColor = grisinactivo,
            cursorColor = negro
        ),
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(16.dp))
    OutlinedTextField(
        value = user,
        onValueChange = { user = it },
        label = { Text(text = "Correo") },
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
    Spacer(modifier = Modifier.height(16.dp))
    Button(
        onClick = { },
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
            text = "Aceptar",
            style = MaterialTheme.typography.labelLarge
        )
    }
}