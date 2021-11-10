package com.example.retrofit_1.ui
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofit_1.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
//
//    fun nextJoke(view: View) {
//        lifecycleScope.launchWhenCreated {
//            val response = try {
//                RetrofitInstance.api.getJoke()
//            } catch (e: IOException) {
//                Log.e(TAG, "IOException")
//                return@launchWhenCreated
//            } catch (e: HttpException) {
//                Log.e(TAG, "HttpException")
//                return@launchWhenCreated
//            }
//            if (response.isSuccessful && response.body() != null) {
//                binding.tvTextJoke.text = response.body()!!.value
//            } else {
//                Log.e(TAG, "Response was not successful")
//            }
//        }
//    }
