package br.com.devhub.ui.webclient.services

import br.com.devhub.ui.webclient.model.GitHubPerfilWeb
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    @GET("/users/{user}")
    suspend fun findProfileBy(@Path("user") user: String): GitHubPerfilWeb
}