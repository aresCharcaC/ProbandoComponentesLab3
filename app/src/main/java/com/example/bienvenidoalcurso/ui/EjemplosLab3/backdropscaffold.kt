package com.example.bienvenidoalcurso.ui.EjemplosLab3

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.Alignment



@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun BackdropScaffoldExample() {
    BackdropScaffold(
        scaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed),
        appBar = {
            TopAppBar(
                title = { Text(text = "backdropscaffold") },
                navigationIcon = {
                    androidx.compose.material3.IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            Icons.Filled.AccountCircle,
                            contentDescription = "cuenta",
                            tint = Color.Red
                        )

                    }
                }
            )
        },
        backLayerContent = {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Contenido de la Capa Trasera", color = Color.White)
            }
        },
        frontLayerContent = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                lazyColumn()
            }
        },


        backLayerBackgroundColor = Color.Blue,
        peekHeight = 60.dp
    )
}

@Preview(showSystemUi = true)
@Composable
fun backdropscaffoldPreview(){
    BackdropScaffoldExample()
}