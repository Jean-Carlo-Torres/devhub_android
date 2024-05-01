package br.com.devhub.ui.webclient

import br.com.devhub.ui.model.Usuario
import br.com.devhub.ui.webclient.services.GitHubService
import br.com.devhub.ui.webclient.services.RetrofitInit
import kotlinx.coroutines.flow.flow

class GitHubWebClient(
    private val service: GitHubService = RetrofitInit().gitHubService
) {
    fun findProfileBy(usuario: String) = flow{
        emit(service.findProfileBy(usuario))
    }
}