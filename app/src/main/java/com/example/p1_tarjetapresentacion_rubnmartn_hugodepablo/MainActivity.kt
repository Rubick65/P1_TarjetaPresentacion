package com.example.p1_tarjetapresentacion_rubnmartn_hugodepablo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.style.TextAlign
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
        ContenedorContacto()
    }
}

/**
 * Función que crea el contenedor que guarda los contactos
 * @param modifier Parámetro que sirve para modificar el contenedor
 */
@Composable
private fun ContenedorContacto(modifier: Modifier = Modifier) {
    val CANTIDAD_CONTACTOS = 4 // Constante con la cantidad de contactos
    val listaIconos = listOf<Int>( // Lista con los ids de referencia de los iconos
        R.drawable.phone_icono,
        R.drawable.share_icono,
        R.drawable.mail_icono,
        R.drawable.github_logo
    )

    val listaTextos = listOf<Int>( // Lista con los ids de referencia para los textos
        R.string.numero_inventado,
        R.string.redes_inventadas,
        R.string.email_inventado,
        R.string.github_inventado
    )

    // Columnas principal que posiciona al contenedor con los contactos abajo y centrado
    Column(
        verticalArrangement = Arrangement.Center,// Posicionar hijos abajo
        horizontalAlignment = Alignment.CenterHorizontally,// Centrar hijos
        modifier = modifier
            .fillMaxSize() // Ocupa todo el espacio en pantalla
    ) {

        // Columna que contiene los contactos
        Column(
            horizontalAlignment = Alignment.Start,// Indicamos que los elementos hijos deben estar pegados al inicio del contenedor
            modifier = Modifier.padding(bottom = 20.dp)
        ) {
            // Iteramos hasta la cantidad de elementos de contacto que tenemos
            for (i in 0 until CANTIDAD_CONTACTOS) {
                // LLamamos a la función que crea una fila con el icono y el contacto que pasamos como argumentos
                FilasContacto(listaTextos[i], listaIconos[i])

                // Sí la posición actual es menor que la cantidad de contactos menos uno
                if (i < CANTIDAD_CONTACTOS - 1)
                // Aplicamos una separación entre cada fila
                    Spacer(Modifier.height(10.dp));
            }
        }

    }
}


@Composable
fun CrearTexto(texto: String, size: Int, modifier: Modifier = Modifier) {
    Text(
        text = texto,
        fontSize = size.sp,
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
            .padding(top = 50.dp)
    ) {
        Row() {
            CrearImagen(logoKotlin,modifier.size(120.dp))
            CrearTexto(stringResource(R.string.union), modifier = modifier.padding(top = 30.dp), size = 50 )
            CrearImagen(logoAndroid, modifier.size(120.dp).padding(start = 15.dp))
        }
        // el size = es para el tamaño de cada palabra
        CrearTexto(stringResource(R.string.nombre1), 30, modifier = modifier.padding(bottom = 15.dp))
        CrearTexto(stringResource(R.string.nombre2), 30)
        CrearTexto(stringResource(R.string.titulo), size = 18, modifier = modifier.padding(top = 30.dp))
    }
}

/**
 * Función que crear las filas con los contactos
 * @param textoID Id que hace referencia al texto del contacto que se va a poner
 * @param imagenId Id que hace referencia a la imagen del contacto que se va a poner
 * @param modifier Parámetro que sirve para modificar el contenedor
 */
@Composable
private fun FilasContacto(
    textoID: Int,
    imagenId: Int,
    modifier: Modifier = Modifier
) {

    // Fila que contiene el icono y el texto del contacot
    Row(
    ) {
        // Icono del contacto
        Icon(
            painter = painterResource(imagenId), // Imagen del icono
            contentDescription = null, //Sin descripción de voz
            tint = Color.White, // Ponemos las imagenes a color negro
            modifier = Modifier
                .size(28.dp) // Tamaño estandar para todos los iconos
        )

        // Separación entre icono y texto
        Spacer(Modifier.width(10.dp))

        // Texto del contacto
        Text(
            text = stringResource(textoID), // String del contacto
            color = Color.White,// Indicamos que el color del texto sea negro
            fontSize = 18.sp
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