package br.com.devhub.ui.webclient.model

import com.squareup.moshi.Json

data class GitHubPerfilWeb(
    val login: String,
    @field:Json(name = "avatar_url")
    val avatar: String,
    val name: String,
    val bio: String
)