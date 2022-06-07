package com.example.notboredapp.data.suggestions

import com.example.notboredapp.data.RepositoryListener
import com.example.notboredapp.models.SuggestionModel

class SuggestionRepository(
    private val remoteDataSource: SuggestionRemoteDataSource
) {

        fun getRandomSuggestion(participantsNumber : Int, listener: RepositoryListener<SuggestionModel>) {
            this.remoteDataSource.getRandomSuggestion(participantsNumber, listener)
        }

        fun getSuggestionByParticipantsAndType(participants: Int,type: String, listener: RepositoryListener<SuggestionModel>) {
            this.remoteDataSource.getSuggestion(participants,type,listener)
        }

}