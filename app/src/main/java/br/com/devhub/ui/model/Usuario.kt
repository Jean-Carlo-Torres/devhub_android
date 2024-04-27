package br.com.devhub.ui.model

import androidx.annotation.DrawableRes

class Usuario (
    @DrawableRes val fotoPerfil: Int,
    val nome: String,
    val usuarioGithub: String,
    val bio: String
)