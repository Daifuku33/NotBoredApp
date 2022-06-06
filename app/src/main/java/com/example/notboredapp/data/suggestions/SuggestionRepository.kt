package com.example.notboredapp.data.suggestions

import com.example.notboredapp.data.RepositoryListener
import com.example.notboredapp.models.SuggestionModel

class SuggestionRepository(
    private val remoteDataSource: SuggestionRemoteDataSource
) {

        fun getRandomSuggestion(listener: RepositoryListener<SuggestionModel>) {
            this.remoteDataSource.getRandomSuggestion(listener)
        }

        fun getSuggestionByParticipantsAndType(participants: Int,type: String, listener: RepositoryListener<SuggestionModel>) {
            this.remoteDataSource.getSuggestion(participants,type,listener)
        }

}