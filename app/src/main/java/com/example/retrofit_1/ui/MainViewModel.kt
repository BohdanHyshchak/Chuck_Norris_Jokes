package com.example.retrofit_1.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit_1.models.Joke
import com.example.retrofit_1.repository.JokeRepository
import com.example.retrofit_1.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(
    val jokeRepository: JokeRepository
) : ViewModel() {
    init {
        Log.i("JokeViewModel", "JokeViewModel created!")
    }

    val joke: MutableLiveData<Resource<Joke>> = MutableLiveData()

    fun getJoke() = viewModelScope.launch {
        joke.postValue(Resource.loading(null))
        val response = jokeRepository.getJoke()
    }

    private fun handleJokeResponse(response: Response<Joke>): Resource<Joke> {
        if (response.isSuccessful) {
            response.body()?.let { resultJoke ->
                return Resource.success(resultJoke)
            }
        }
        return Resource.error("Smth went wrong", null)
    }
}
