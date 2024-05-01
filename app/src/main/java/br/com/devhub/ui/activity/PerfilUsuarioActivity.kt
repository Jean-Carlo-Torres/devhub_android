package br.com.devhub.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import br.com.devhub.R
import br.com.devhub.ui.activity.ui.theme.DevHubTheme
import br.com.devhub.ui.model.Usuario
import br.com.devhub.ui.webclient.services.RetrofitInit
import coil.compose.AsyncImage
import kotlinx.coroutines.launch

class PerfilDevActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            RetrofitInit().gitHubService.findProfileBy("Jean-Carlo-Torres").let {
                Log.i("PerfilUsuarioActicity", "onCreate: $it")
            }
        }
        setContent {
            DevHubTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    exibePerfilDev(usuario())
                }
            }
        }
    }
}

@Composable
fun exibePerfilDev(usuario: Usuario) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color.Black, Color.Blue),
                            startY = 0f,
                            endY = 700f
                        )
                    )
            )
            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = "https://avatars.githubusercontent.com/u/138898021?v=4",
                    contentDescription = null,
                    Modifier
                        .size(200.dp)
                        .clip(shape = CircleShape)
                        .border(
                            width = 2.dp,
                            color = Color.White,
                            shape = CircleShape
                        ),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = R.drawable.placeholder)
                )
                Text(
                    text = usuario.name,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(
                    text = usuario.login,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = usuario.bio,
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun exibePerfilDevPreview() {
    exibePerfilDev(
        usuario()
    )
}

fun usuario() = Usuario(
    name = "Jean Carlo",
    login = "Jean-Carlo-Torres",
    bio = "biografia"
)
