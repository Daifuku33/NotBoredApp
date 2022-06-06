package com.example.notboredapp.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notboredapp.data.RepositoryError
import com.example.notboredapp.data.RepositoryListener
import com.example.notboredapp.data.RepositoryResponse
import com.example.notboredapp.data.suggestions.SuggestionRepository
import com.example.notboredapp.models.SuggestionModel

class SuggestionViewModel(
    private val repository: SuggestionRepository
): ViewModel() {

    val suggestion = MutableLiveData<SuggestionModel?>(null)
    val loading = MutableLiveData<Boolean>(false)
    val error = MutableLiveData<String?>(null)

    fun getRandomSuggestion() {

        error.value = null
        suggestion.value = null
        loading.value = true

        repository.getRandomSuggestion(object: RepositoryListener<SuggestionModel> {

            override fun onResponse(response: RepositoryResponse<SuggestionModel>) {
                val suggestionResponse = response.data

                loading.value = false
                error.value = null
                suggestion.value = suggestionResponse
            }

            override fun onError(repositoryError: RepositoryError) {
                val message = "${repositoryError.message} (code: ${repositoryError.code})"

                loading.value = false
                error.value = message
                suggestion.value = null
            }

        })
    }

}

