package br.com.devhub.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import br.com.devhub.ui.activity.ui.theme.DevHubTheme
import br.com.devhub.ui.model.Usuario
import br.com.devhub.ui.screen.exibeTelaDePerfil
import br.com.devhub.ui.webclient.services.RetrofitInit
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
                    exibeTelaDePerfil("Jean-Carlo-Torres")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun exibePerfilDevPreview() {
    exibeTelaDePerfil(
        "Jean-Carlo-Torres"
    )
}


