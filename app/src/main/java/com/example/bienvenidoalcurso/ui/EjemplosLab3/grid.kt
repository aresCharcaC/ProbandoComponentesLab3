package com.example.bienvenidoalcurso.ui.EjemplosLab3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bienvenidoalcurso.ui.Data.Pokemon
import com.example.bienvenidoalcurso.ui.Data.getPokemon
import com.example.bienvenidoalcurso.ui.Data.itemPokemon


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonGridApp() {
    var pokemonSelected by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Pokédex Grid") }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Text(
                text = "Pokémon seleccionado: $pokemonSelected",
                modifier = Modifier.padding(16.dp)
            )
            PokemonGrid(
                onPokemonSelected = { pokemonSelected = it.nombre }
            )
        }
    }
}

@Composable
fun PokemonGrid(onPokemonSelected: (Pokemon) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(getPokemon()) { pokemon ->
            itemPokemon(
                pokemonTurno = pokemon,
                onPokemonClic = onPokemonSelected
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PokemonGridAppPreview() {
        PokemonGridApp()

}