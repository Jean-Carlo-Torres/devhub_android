package br.com.devhub.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.devhub.ui.model.Usuario

@Composable
fun BuscaUsuarioScreen(onUsuarioBuscado: (String) -> Unit) {
    Column(
        modifier = Modifier
            .padding(top = 120.dp, start = 16.dp, end = 16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier =
            Modifier
                .height(100.dp)
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)

        ) {
            Text(
                text = "Bem-Vindo ao DevHub",
                style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
            )

            Text(
                text = "Busque por um usuário do GitHub",
                style = TextStyle(fontSize = 16.sp),
            )
        }

        var textFieldValue by remember { mutableStateOf(TextFieldValue()) }

        OutlinedTextField(
            value = textFieldValue,
            onValueChange = { textFieldValue = it },
            label = { Text("Usuário") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                onUsuarioBuscado(textFieldValue.text)
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Buscar")
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun BuscaUsuarioScreenPreview() {
    BuscaUsuarioScreen(onUsuarioBuscado = {
        println(it)
    })
}