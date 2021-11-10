package com.example.retrofit_1.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit_1.repository.JokeRepository

class MainViewModelProviderFactory(
    val jokeRepository: JokeRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(jokeRepository) as T
    }
}
//