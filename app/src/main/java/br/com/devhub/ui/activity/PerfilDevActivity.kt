package br.com.devhub.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.devhub.R
import br.com.devhub.ui.activity.ui.theme.DevHubTheme
import br.com.devhub.ui.model.Usuario

class PerfilDevActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(usuario.fotoPerfil),
            contentDescription = null,
            Modifier
                .size(200.dp)
                .clip(shape = CircleShape),
            contentScale = ContentScale.Crop
        )
        Text(
            text = usuario.nome,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.offset(y = 8.dp)
                .padding(16.dp)
        )
        Text(
            text = usuario.usuarioGithub,
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = usuario.bio,
        )
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
    fotoPerfil = R.drawable.ic_launcher_background,
    nome = "Jean Carlo",
    usuarioGithub = "Jean-Carlo-Torres",
    bio = "biografia"
)
