package com.example.bienvenidoalcurso.ui.Data

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bienvenidoalcurso.R

@Composable
fun itemPokemon(
    pokemonTurno: Pokemon,
    onPokemonClic:(Pokemon)->Unit            ) {

    var imgPokemon by remember {
        mutableStateOf("mewtwo")
    }

    var imageResource = when (imgPokemon) {
        "pikachu" -> R.drawable.pikachu
        else -> R.drawable.mewtwo
    }
    Card (
        border = BorderStroke(
            width = 5.dp,
            color = Color.Black),
        modifier = Modifier
            .height(290.dp)
            .fillMaxWidth()
            .clickable {
                imgPokemon = if (imgPokemon == "mewtwo") "pikachu" else "mewtwo"
                onPokemonClic(pokemonTurno)
            },

    ){
        Column (

            ){
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = "pokemon",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .align(Alignment.CenterHorizontally)
                    .weight(1f),
                contentScale = ContentScale.Fit,
                alignment = Alignment.Center)



            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Color(android.graphics.Color.parseColor("#FF090F20")),
                        shape = RoundedCornerShape(16.dp)
                    ) // Fondo con esquinas redondeadas
                    .padding(16.dp)



            ) {
                Text(
                    text = pokemonTurno.nombre,
                    color = Color.White,
                    fontSize = 25.sp,
                )
            }
        }
    }


}
