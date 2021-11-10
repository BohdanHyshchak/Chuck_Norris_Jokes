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
//
    init {
        // getJoke()
        Log.i("JokeViewModel", "JokeViewModel created!")
    }

    val joke: MutableLiveData<Resource<Joke>> = MutableLiveData()
    var textOfJoke = ""

    fun getJoke() = viewModelScope.launch {
        joke.postValue(Resource.Loading())
        val response = jokeRepository.getJoke()
        joke.postValue(handleJokeResponse(response))
    }

    private fun handleJokeResponse(response: Response<Joke>): Resource<Joke> {
        if (response.isSuccessful) {
            response.body()?.let { resultJoke ->
                return Resource.Success(resultJoke)
            }
        }
        return Resource.Error("Smth went wrong", null)
    }
}
