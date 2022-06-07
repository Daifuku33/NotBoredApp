package com.example.notboredapp.data.suggestions

import com.example.notboredapp.data.*
import com.example.notboredapp.models.SuggestionModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SuggestionRemoteDataSource {

    fun getRandomSuggestion(participantsNumber: Int,listener: RepositoryListener<SuggestionModel>) {

        val service = RetrofitService.instance
            .create(SuggestionService::class.java)
            .getRandomSuggestion(participantsNumber)

        service.enqueue(object : Callback<SuggestionModel> {

            override fun onResponse(
                call: Call<SuggestionModel>,
                response: Response<SuggestionModel>
            ) {
                val suggestion = response.body()
                if (response.isSuccessful && suggestion != null) {
                    listener.onResponse(
                        RepositoryResponse(
                            data = suggestion,
                            source = Source.REMOTE
                        )
                    )
                } else {
                    listener.onError(
                        RepositoryError(
                            message = "El servidor rechazó la solicitud",
                            code = response.code(),
                            source = Source.REMOTE
                        )
                    )
                }
            }

            override fun onFailure(call: Call<SuggestionModel>, t: Throwable) {
                listener.onError(
                    RepositoryError(
                        message = t.message ?: "Error inesperado",
                        code = -1,
                        source = Source.REMOTE
                    )
                )
            }

        })
    }


    fun getSuggestion(
        participants: Int,
        type: String,
        listener: RepositoryListener<SuggestionModel>
    ) {
        val service = RetrofitService.instance
            .create(SuggestionService::class.java)
            .getSuggestionByParticipantsAndType(participants, type)

        service.enqueue(object : Callback<SuggestionModel> {

            override fun onResponse(
                call: Call<SuggestionModel>,
                response: Response<SuggestionModel>
            ) {
                val suggestion = response.body()
                if (response.isSuccessful && suggestion != null) {
                    listener.onResponse(
                        RepositoryResponse(
                            data = suggestion,
                            source = Source.REMOTE
                        )
                    )
                } else {
                    listener.onError(
                        RepositoryError(
                            message = "El servidor rechazó la solicitud",
                            code = response.code(),
                            source = Source.REMOTE
                        )
                    )
                }
            }

            override fun onFailure(call: Call<SuggestionModel>, t: Throwable) {
                listener.onError(
                    RepositoryError(
                        message = t.message ?: "Error inesperado",
                        code = -1,
                        source = Source.REMOTE
                    )
                )
            }

        })
    }
}