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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    val imagen = painterResource(R.drawable.fondo)
    Box(modifier = modifier) {
        Image(
            painter = imagen,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Aquí va la función del centro (Hugo De Pablo)

        // Aquí va la función de abajo (Rubén Martín Andrade)
        ContenedorContacto()
    }
}

@Composable
private fun ContenedorContacto(modifier: Modifier = Modifier) {
    val CANTIDAD_CONTACTOS = 4
    val listaIconos = listOf<Int>(
        R.drawable.phone_icono,
        R.drawable.share_icono,
        R.drawable.mail_icono,
        R.drawable.github_logo
    )

    val listaTextos = listOf<Int>(
        R.string.numero_inventado,
        R.string.redes_inventadas,
        R.string.email_inventado,
        R.string.github_inventado
    )

    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 40.dp)
    ) {

        for (i in 0 until CANTIDAD_CONTACTOS) {
            FilasContacto(listaTextos[i], listaIconos[i])
            Spacer(Modifier.height(10.dp))
        }

    }
}

@Composable
private fun FilasContacto(
    textoID: Int,
    imagenId: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier.padding(start = 50.dp, end = 40.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(imagenId),
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .size(24.dp)
            )

            Spacer(Modifier.width(10.dp))

            Text(
                text = stringResource(textoID),
                textAlign = TextAlign.Start,
                color = Color.Black
            )
        }

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