package com.example.disneyapp.data.remote.endpoints

import com.example.disneyapp.data.remote.network.DataModel
import com.example.disneyapp.data.remote.network.DisneyModel
import retrofit2.http.GET

interface DisneyEndpoints {

    @GET("character")
    suspend fun getCharacters(): DisneyModel

    @GET("character/_id")
    suspend fun getCharacter(charId: String?): DataModel
}