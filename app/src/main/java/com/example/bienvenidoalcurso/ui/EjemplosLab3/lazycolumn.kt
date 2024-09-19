package com.example.bienvenidoalcurso.ui.EjemplosLab3

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bienvenidoalcurso.BusinessCard
import com.example.bienvenidoalcurso.ui.Data.getPokemon
import com.example.bienvenidoalcurso.ui.Data.itemPokemon
import com.example.bienvenidoalcurso.ui.theme.BienvenidoAlCursoTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun lazyColumn(){

    var pokemonSlected by remember {
        mutableStateOf("mewtwo")
    }
    Column {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            stickyHeader {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(3.dp)
                        .background(Color.LightGray)
                ) {
                    Text("${pokemonSlected}",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
            items(getPokemon()) {
                itemPokemon(pokemonTurno = it,
                    onPokemonClic = {
                        pokemonSlected = it.nombre

                    })
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BienvenidoAlCursoTheme {
        lazyColumn()

    }
}