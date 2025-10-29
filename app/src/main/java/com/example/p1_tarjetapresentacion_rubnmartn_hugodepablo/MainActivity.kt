package com.example.p1_tarjetapresentacion_rubnmartn_hugodepablo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.p1_tarjetapresentacion_rubnmartn_hugodepablo.ui.theme.P1_TarjetaPresentacion_RubénMartín_HugoDePabloTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            P1_TarjetaPresentacion_RubénMartín_HugoDePabloTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ContenedorUI(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ContenedorUI(modifier: Modifier = Modifier) {
    val imagen = painterResource(R.drawable.gengar)
    Box(modifier = modifier) {
        Image(
            painter = imagen,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        // Aquí va la función del centro (Hugo De Pablo)
        ContenedorCentro()
        // Aquí va la función de abajo (Rubén Martín Andrade)
    }
}

@Composable
fun CrearTexto(texto: String, modifier: Modifier = Modifier) {
    Text(
        text = texto,
        fontSize = 50.sp,
        color = Color.White,
        lineHeight = 20.sp,
        modifier = modifier
    )
}

@Composable
fun CrearImagen(imagen: Painter, modifier: Modifier = Modifier) {
    Image(
        painter = imagen,
        contentDescription = null,
        modifier = modifier
    )
}

@Composable
fun ContenedorCentro(modifier: Modifier = Modifier) {
    val logoKotlin = painterResource(R.drawable.kotlin_logo)
    val logoAndroid = painterResource(R.drawable.android_studio_logo)
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(top = 10.dp)
    ) {
        Row() {
            CrearImagen(logoKotlin,modifier.size(120.dp))
            CrearTexto(stringResource(R.string.union), modifier.padding(top = 30.dp))
            CrearImagen(logoAndroid, modifier.size(120.dp).padding(start = 15.dp))
        }
        CrearTexto(stringResource(R.string.nombre1))
        CrearTexto(stringResource(R.string.enlace))
        CrearTexto(stringResource(R.string.nombre2))
        Text(
            text = stringResource(R.string.titulo),
            color = Color.Green,
            fontSize = 18.sp,
            modifier = modifier.padding(top = 10.dp)
        )
    }


}


@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "My preview"
)
@Composable
fun GreetingPreview() {
    P1_TarjetaPresentacion_RubénMartín_HugoDePabloTheme {
        ContenedorUI(modifier = Modifier.fillMaxSize())
    }
}