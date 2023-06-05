package com.metehanbolat.data.api

import com.metehanbolat.data.dto.Character
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyApi {

    @GET("character/{id}")
    suspend fun getSingleCharacter(@Path("id") id: String): Character
}