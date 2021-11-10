package com.example.retrofit_1.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api: JokesApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JokesApi::class.java)
    }
}
