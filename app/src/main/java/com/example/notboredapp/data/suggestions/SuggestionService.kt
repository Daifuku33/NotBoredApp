package com.example.notboredapp.data.suggestions

import com.example.notboredapp.models.SuggestionModel
import retrofit2.Call
import retrofit2.http.*

interface SuggestionService {

    @GET("/api/activity")
    fun getRandomSuggestion(@Query("participants") participants: Int): Call<SuggestionModel>

    @GET("/api/activity")
    fun getSuggestionByParticipantsAndType(@Query("participants") participants: Int, @Query("type") type: String): Call<SuggestionModel>

}