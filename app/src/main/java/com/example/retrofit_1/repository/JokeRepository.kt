package com.example.retrofit_1.repository

import com.example.retrofit_1.api.RetrofitInstance

class JokeRepository() {

    suspend fun getJoke() =
        RetrofitInstance.api.getJoke()
}
