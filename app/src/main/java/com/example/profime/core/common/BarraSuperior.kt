package com.example.profime.core.estudiante

import android.graphics.drawable.Icon
import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.profime.ui.theme.azul
import com.example.profime.ui.theme.azulclaro
import com.example.profime.ui.theme.negro
import com.example.profime.ui.theme.verdebarras
import com.example.profime.ui.theme.verdemilitar
import com.example.profime.ui.theme.verdeverde

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraSuperior(){
    val context = LocalContext.current.applicationContext
    TopAppBar(
        title = { Text(text = "Merari Licea") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = verdeverde,
            titleContentColor = negro,
            navigationIconContentColor = negro
        ),
        navigationIcon = {
            IconButton(onClick = { Toast.makeText(context, "Presionaste el menú", Toast.LENGTH_SHORT).show()}) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
            }
        }
    )
}