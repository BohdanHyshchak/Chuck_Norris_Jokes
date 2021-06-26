package com.example.retrofit_1

import retrofit2.Response
import retrofit2.http.GET

interface JokesApi {
    
    @GET("/jokes/random")
    suspend fun getJoke(): Response<Joke>
}