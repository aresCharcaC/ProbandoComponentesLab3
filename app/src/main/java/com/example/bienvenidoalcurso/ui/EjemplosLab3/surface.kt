package com.example.bienvenidoalcurso.ui.EjemplosLab3

import android.view.Surface
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bienvenidoalcurso.R
import com.example.bienvenidoalcurso.ui.theme.BienvenidoAlCursoTheme

@Composable
fun BusinessCard() {
    val padding = 16.dp
    val iconSize = 24.dp
    val textSize = 18.sp

    Column(
        modifier = androidx.compose.ui.Modifier
            .padding(padding)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Sección de logotipo, nombre y cargo
        Image(
            painter = painterResource(id = R.drawable.androidhead),
            contentDescription = "Android Logo",
            modifier = androidx.compose.ui.Modifier.size(100.dp)
        )
        Spacer(modifier = androidx.compose.ui.Modifier.height(padding))
        Text(
            text = "Tu Nombre",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = androidx.compose.ui.Modifier.padding(vertical = padding)
        )
        Text(
            text = "Desarrollador Android",
            fontSize = textSize,
            color = MaterialTheme.colorScheme.secondary,
            modifier = androidx.compose.ui.Modifier.padding(vertical = padding)
        )
        Spacer(modifier = androidx.compose.ui.Modifier.height(padding * 2))
        // Sección de información de contacto
        Column(
            modifier = androidx.compose.ui.Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            ContactInfo(
                icon = R.drawable.ic_phone,
                text = "+51 987 654 321"
            )
            Spacer(modifier = androidx.compose.ui.Modifier.height(padding / 2))
            ContactInfo(
                icon = R.drawable.ic_gmail,
                text = "email@example.com"
            )
        }
    }
}

@Composable
fun ContactInfo(icon: Int, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = androidx.compose.ui.Modifier.padding(vertical = 8.dp)
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = androidx.compose.ui.Modifier.size(24.dp)
        )
        Spacer(modifier = androidx.compose.ui.Modifier.width(8.dp))
        Text(text = text)
    }
}

@Preview(showSystemUi = true)
@Composable
fun SurfacePreview() {
    BienvenidoAlCursoTheme {
        Surface(
            modifier = androidx.compose.ui.Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            BusinessCard()
        }
    }
}