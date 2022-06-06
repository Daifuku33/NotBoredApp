package com.example.notboredapp.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notboredapp.data.suggestions.*

class SuggestionModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        val remoteDataSource = SuggestionRemoteDataSource()
        val repository = SuggestionRepository(remoteDataSource)

        return SuggestionViewModel(repository) as T
    }
}