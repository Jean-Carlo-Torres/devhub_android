package br.com.devhub.ui.webclient.services

import br.com.devhub.ui.webclient.model.GitHubPerfilWeb
import br.com.devhub.ui.webclient.model.GitHubRepository
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    @GET("/users/{user}")
    suspend fun findProfileBy(@Path("user") user: String): GitHubPerfilWeb

    @GET("/users/{user}/repos")
    suspend fun findRepositoriesBy(@Path("user") user: String): List<GitHubRepository>
}