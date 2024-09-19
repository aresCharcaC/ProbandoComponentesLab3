package com.example.bienvenidoalcurso.ui.Data

data class Pokemon(
    val id:Int,
    val nombre:String,
    val image:String
)
fun getPokemon():List<Pokemon> =(1 ..151).map{

    Pokemon(
        id=it,
        nombre="${it}Pokemon",
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$it.png"
    )

}

