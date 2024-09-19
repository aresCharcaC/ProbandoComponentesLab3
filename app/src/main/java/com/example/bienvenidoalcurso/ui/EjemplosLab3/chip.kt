package com.example.bienvenidoalcurso.ui.EjemplosLab3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Chip
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.tooling.preview.Preview
import com.example.bienvenidoalcurso.ui.theme.BienvenidoAlCursoTheme


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ChipAndButtonExample() {
    var isChipSelected by remember { mutableStateOf(false) }
    var buttonClickCount by remember { mutableStateOf(0) }

    Column(modifier = Modifier.padding(16.dp)) {
        Chip(
            onClick = { isChipSelected = !isChipSelected }
        ) {
            Text(text = if (isChipSelected) "Seleccionado" else "No seleccionado")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { buttonClickCount++ }) {
            Text(text = "Clicks: $buttonClickCount")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ChipPreview() {
    BienvenidoAlCursoTheme {
            ChipAndButtonExample()

    }
}

