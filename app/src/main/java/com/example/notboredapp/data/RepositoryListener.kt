package com.example.notboredapp.data

interface RepositoryListener<T> {

    fun onResponse(response: RepositoryResponse<T>)

    fun onError(repositoryError: RepositoryError)

}