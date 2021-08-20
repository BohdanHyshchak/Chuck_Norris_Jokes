package com.example.retrofit_1.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.retrofit_1.R
import com.example.retrofit_1.ui.MainActivity
import com.example.retrofit_1.ui.MainViewModel

class JokeFragment : Fragment(R.layout.activity_main) {

    lateinit var viewModel: MainViewModel

    val TAG = "Joke Fragment"


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        setupUI()
    }

    private fun setupUI() {
        
    }
}