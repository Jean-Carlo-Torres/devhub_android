package br.com.devhub.ui.screen

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.devhub.R
import br.com.devhub.ui.model.Usuario
import br.com.devhub.ui.webclient.GitHubWebClient
import coil.compose.AsyncImage

@Composable
fun exibeTelaDePerfil(
    usuario: String,
    webClient: GitHubWebClient = GitHubWebClient()
) {
    val foundUser by webClient.findProfileBy(usuario)
        .collectAsState(initial = null)
    val nome = remember { mutableStateOf("") }
    val login = remember { mutableStateOf("") }
    val bio = remember { mutableStateOf("") }
    val avatar = remember { mutableStateOf("") }

    foundUser?.let { perfilUsuario ->
        nome.value = perfilUsuario.name
        login.value = perfilUsuario.login
        bio.value = perfilUsuario.bio
        avatar.value = perfilUsuario.avatar
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
                        model = perfilUsuario.avatar,
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
                        text = perfilUsuario.name,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                    Text(
                        text = perfilUsuario.login,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = perfilUsuario.bio,
                    )
                }
            }
        }
    }
}

