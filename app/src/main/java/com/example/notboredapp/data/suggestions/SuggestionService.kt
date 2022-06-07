package com.example.notboredapp.data.suggestions

import com.example.notboredapp.models.SuggestionModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface SuggestionService {

    @GET("/api/activity?participants={participants}")
    fun getRandomSuggestion(@Path("participants") participants: Int): Call<SuggestionModel>

    @GET("/api/activity?participants={participants}&type={type}")
    fun getSuggestionByParticipantsAndType(@Path("participants") participants: Int,@Path("type") type: String): Call<SuggestionModel>


}