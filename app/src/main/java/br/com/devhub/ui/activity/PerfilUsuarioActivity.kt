package br.com.devhub.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.devhub.ui.activity.ui.theme.DevHubTheme
import br.com.devhub.ui.screen.BuscaUsuarioScreen
import br.com.devhub.ui.screen.PerfilUsuarioScreen

class PerfilDevActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var usuario by mutableStateOf("")

        setContent {
            DevHubTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    if (usuario.isEmpty()) {
                        BuscaUsuarioScreen(onUsuarioBuscado = { usuarioBuscado ->
                            usuario = usuarioBuscado
                        })
                    } else {
                        PerfilUsuarioScreen(usuario)
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun exibePerfilDevPreview() {

}


