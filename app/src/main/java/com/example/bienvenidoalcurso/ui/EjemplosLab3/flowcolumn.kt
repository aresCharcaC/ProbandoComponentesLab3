package com.example.bienvenidoalcurso.ui.EjemplosLab3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bienvenidoalcurso.ui.theme.BienvenidoAlCursoTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowColumnExample() {
    val items = listOf("Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho")

    FlowColumn(
        modifier = Modifier
            .padding(8.dp)
            .width(200.dp), // Limitamos el ancho para forzar el flujo
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        maxItemsInEachColumn = 4 // Opcional: limita el número de items por columna
    ) {
        items.forEach { item ->
            Button(
                onClick = { /* Acción al hacer clic */ },
                modifier = Modifier.width(90.dp) // Ancho fijo para los botones
            ) {
                Text(item)
            }
        }
    }
}
@Preview(showSystemUi = true)
@Composable
fun ColumnRowPreview() {
    BienvenidoAlCursoTheme {
        FlowRowExample()

    }
}