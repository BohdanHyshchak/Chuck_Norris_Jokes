package com.example.retrofit_1.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit_1.R
import com.example.retrofit_1.databinding.JokeFragmentBinding
import com.example.retrofit_1.repository.JokeRepository
import com.example.retrofit_1.ui.MainViewModel
import com.example.retrofit_1.ui.MainViewModelProviderFactory
import com.example.retrofit_1.util.Resource

class JokeFragment : Fragment() {
//
    lateinit var binding: JokeFragmentBinding
    lateinit var viewModel: MainViewModel
    lateinit var viewModelFactory: MainViewModelProviderFactory
    val TAG = "Joke Fragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.joke_fragment,
            container,
            false
        )
        val jokeRepository = JokeRepository()
        viewModelFactory = MainViewModelProviderFactory(jokeRepository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        binding.btnNextJoke.setOnClickListener { nextJoke() }
        updateUI()
        return binding.root
    }
    private fun nextJoke() {
        viewModel.getJoke()
        updateUI()
    }

    private fun updateUI() {
        viewModel.joke.observe(
            viewLifecycleOwner,
            Observer { response ->
                when (response) {
                    is Resource.Success -> {
                        response.data?.let {
                            binding.tvTextJoke.text = it.value
                        }
                    }
                    is Resource.Loading -> {
                        Log.e(TAG, "Smth went wrong")
                    }
                }
            }
        )
    }
}
