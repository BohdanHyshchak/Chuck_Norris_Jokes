package com.example.retrofit_1.ui
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.retrofit_1.api.RetrofitInstance
import com.example.retrofit_1.databinding.ActivityMainBinding
import retrofit2.HttpException
import java.io.IOException

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
    fun nextJoke(view: View) {

        lifecycleScope.launchWhenCreated {
            val response = try {
                RetrofitInstance.api.getJoke()
            } catch (e: IOException) {
                Log.e(TAG, "IOException")
                return@launchWhenCreated
            } catch (e: HttpException) {
                Log.e(TAG, "HttpException")
                return@launchWhenCreated
            }
            if (response.isSuccessful && response.body() != null) {
                binding.tvTextJoke.text = response.body()!!.value
            } else {
                Log.e(TAG, "Response was not successful")
            }
        }
    }
}
