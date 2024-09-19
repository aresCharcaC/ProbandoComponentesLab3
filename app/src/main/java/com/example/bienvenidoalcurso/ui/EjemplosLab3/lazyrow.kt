package com.example.bienvenidoalcurso.ui.EjemplosLab3

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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

@Composable
fun lazyrow(){


    var pokemonSlected by remember {
        mutableStateOf("mewtwo")
    }
    Column {
        Text(text = "${pokemonSlected}")
        LazyRow(
            modifier = Modifier.fillMaxWidth()
            ,
            contentPadding = PaddingValues(8.dp),

            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ){
            items(getPokemon()){
                itemPokemon(pokemonTurno = it,
                    onPokemonClic={
                        pokemonSlected=it.nombre

                    })
            }

        }
    }



}

@Preview(showSystemUi = true)
@Composable
fun lazyrowPreview() {
    BienvenidoAlCursoTheme {
        lazyrow()

    }
}