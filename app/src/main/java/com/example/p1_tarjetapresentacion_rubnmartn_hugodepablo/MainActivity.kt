package com.example.p1_tarjetapresentacion_rubnmartn_hugodepablo

//Creado por Hugo de Pablo López y Rubén Martín Andrade

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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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

/**
 * Función que contiene todos los elementos de la interfaz
 * @param modifier Sirve para modificar las propiedades del contenedor
 */
@Composable
private fun ContenedorUI(modifier: Modifier = Modifier) {
    val imagen = painterResource(R.drawable.gengar2) //fondo de pantalla
    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = imagen,
            contentDescription = null, //Quitamos descripcíon de audio.
            contentScale = ContentScale.Crop, //Para que ocupe toda la pantalla
            modifier = Modifier.fillMaxSize()
        )
        // Aquí va la función del centro (Hugo De Pablo López)
        ContenedorCentro(modifier = Modifier.align(Alignment.Center))
        // Aquí va la función de abajo (Rubén Martín Andrade)
        ContenedorContacto(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

/**
 * Funcion que contiene la presentacion principal del equipo
 * @param modifier para modificar las caracteristicas del contenedor
 */
@Composable
private fun ContenedorCentro(modifier: Modifier = Modifier) {
    //Imagenes a implementar
    val logoAndroid = painterResource(R.drawable.android_studio_logo)
    val logoKotlin = painterResource(R.drawable.kotlin_logo)

    //Columna que contiene a todos los elementos
    Column(
        //Indicamos que se centre en el medio
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        //Fila que contendra las imagenes principales.
        Row(
            modifier = Modifier.padding(bottom = 10.dp), //Separacion con la descripcion de abajo
            verticalAlignment = Alignment.CenterVertically // Centramos todos los elementos
        ) {
            //Se crean las imagenes, indicandoles la imagen y su tamaño
            CrearImagen(
                logoAndroid,
                Modifier
                    .size(120.dp)
            )
            CrearTexto(
                stringResource(R.string.union), //Se crea un texto de enlace entre imagenes
                modifier = Modifier.padding(start = 10.dp), //Se ajusta para que quede centrado
                size = 50
            )
            CrearImagen(
                logoKotlin,
                Modifier.size(130.dp)
            )
        }

        //Se crea los nombres y la descripcion
        CrearTexto(
            stringResource(R.string.nombre1),
            30,
            modifier = Modifier.padding(bottom = 15.dp),
        )
        CrearTexto(
            stringResource(R.string.nombre2),
            30
        )
        CrearTexto(
            stringResource(R.string.titulo),
            size = 24,
            modifier = Modifier.padding(top = 30.dp)
        )
    }
}

/**
 * Función que crea el contenedor que guarda los contactos
 * @param modifier Sirve para modificar las propiedades del contenedor
 */
@Composable
private fun ContenedorContacto(modifier: Modifier = Modifier) {
    val cantidadContactos = 4 // Constante con la cantidad de contactos
    val listaIconos = listOf( // Lista con los ids de referencia de los iconos
        R.drawable.phone_icono,
        R.drawable.share_icono,
        R.drawable.mail_icono,
        R.drawable.github_logo
    )

    val listaTextos = listOf( // Lista con los ids de referencia para los textos
        R.string.numero_inventado,
        R.string.redes_inventadas,
        R.string.email_inventado,
        R.string.github_inventado
    )

    // Columna que contiene los contactos
    Column(
        horizontalAlignment = Alignment.Start,// Indicamos que los elementos hijos deben estar pegados al inicio del contenedor
        modifier = modifier.padding(bottom = 15.dp) // Indicamos un padding abajo para separar el contenedor
            .width(275.dp) // Indicamos un tamaño fijo para la columna
    ) {
        // Iteramos hasta la cantidad de elementos de contacto que tenemos
        for (i in 0 until cantidadContactos) {
            // LLamamos a la función que crea una fila con el icono y el contacto que pasamos como argumentos
            FilasContacto(listaTextos[i], listaIconos[i])

            // Sí la posición actual es menor que la cantidad de contactos menos uno
            if (i < cantidadContactos - 1)
            // Aplicamos una separación entre cada fila
                Spacer(Modifier.height(10.dp))
        }
    }
}

/**
 * Función que crear las filas con los contactos
 * @param textoID Id que hace referencia al texto del contacto que se va a poner
 * @param imagenId Id que hace referencia a la imagen del contacto que se va a poner
 * @param modifier Sirve para modificar las propiedades del contenedor
 */
@Composable
private fun FilasContacto(
    textoID: Int,
    imagenId: Int,
    modifier: Modifier = Modifier
) {
    // Fila que contiene el icono y el texto del contacto
    Row(
        verticalAlignment = Alignment.CenterVertically, // Centramos todos los elementos verticalmente
        modifier = Modifier.fillMaxWidth() // Hacemos que la fila ocupe todo el largo de la columna
    ) {
        // Icono del contacto
        Icon(
            painter = painterResource(imagenId), // Imagen del icono
            contentDescription = null, //Sin descripción de voz
            tint = Color.White, // Ponemos las imagenes a color blanco
            modifier = Modifier
                .size(29.dp) // Tamaño estandar para todos los iconos
        )

        // Separación entre icono y texto
        Spacer(Modifier.width(10.dp))

        // Texto del contacto
        CrearTexto(
            stringResource(textoID),
            size = 18,
            )

    }
}

/**
 * Funcion para crear el texto de los contenedores
 * @param texto texto a poner
 * @param size tamaño del texto a introducir
 * @param modifier para modificar las caracteristicas del texto
 */
@Composable
private fun CrearTexto(texto: String, size: Int, modifier: Modifier = Modifier) {
    Text(
        text = texto,
        fontSize = size.sp,
        color = Color.White, //Color blanco predeterminado
        lineHeight = 20.sp, //Espacio predeterminado entre filas
        modifier = modifier
    )
}

/**
 * Funcion para crear una imagen en el contenedor
 * @param imagen imagen a enseñar
 * @param modifier para modificar las caracteristicas de la imagen
 */
@Composable
private fun CrearImagen(imagen: Painter, modifier: Modifier = Modifier) {
    Image(
        painter = imagen,
        contentDescription = null, //Quitamos descripcion de audio
        modifier = modifier
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true, //Para que se muestre como si fuera el teléfono
    name = "Tarjeta de presentación"
)
@Composable
fun GreetingPreview() {
    P1_TarjetaPresentacion_RubénMartín_HugoDePabloTheme {
        ContenedorUI(modifier = Modifier.fillMaxSize())
    }
}