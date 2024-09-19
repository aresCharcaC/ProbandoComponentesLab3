package com.example.bienvenidoalcurso.ui.EjemplosLab3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Chip
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bienvenidoalcurso.ui.theme.BienvenidoAlCursoTheme

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterialApi::class)
@Composable
fun FlowRowExample() {
    val items = listOf("Manzana", "Banana", "Cereza", "Dátil", "Elderberry", "Fresa", "Guayaba", "Higo")

    FlowRow(
        modifier = Modifier.padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items.forEach { item ->
            Chip(
                onClick = { /* Acción al hacer clic */ }
            ) {
                Text(item)
            }
        }
    }
}
@Preview(showSystemUi = true)
@Composable
fun FlowRowPreview() {
    BienvenidoAlCursoTheme {
        FlowRowExample()

    }
}
