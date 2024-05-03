package br.com.devhub.ui.webclient

import android.util.Log
import br.com.devhub.ui.model.Usuario
import br.com.devhub.ui.webclient.model.GitHubRepository
import br.com.devhub.ui.webclient.services.GitHubService
import br.com.devhub.ui.webclient.services.RetrofitInit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GitHubWebClient(
    private val service: GitHubService = RetrofitInit().gitHubService
) {
    fun findProfileBy(usuario: String) = flow {
        try {
            emit(service.findProfileBy(usuario))

        } catch (e: Exception) {
            Log.e("GitHubWebClient", "findProfileBy: falha ao buscar usuário", e)
        }
    }

    fun findRepositoriesBy(usuario: String): Flow<List<GitHubRepository>> = flow {
        try {
            emit(service.findRepositoriesBy(usuario))
        } catch (e: Exception) {
            Log.e("GitHubWebClient", "findRepositoriesBy: falha ao buscar repositórios", e)
        }
    }
}