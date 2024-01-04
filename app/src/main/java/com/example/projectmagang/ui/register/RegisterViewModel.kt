package com.example.projectmagang.ui.register

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projectmagang.model.RegisterResultResponse
import com.example.projectmagang.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/** Raihan Chaira on 1/4/2024
 * raihanchaira21@gmail.com
 */
class RegisterViewModel : ViewModel() {

    val registerResult = MutableLiveData<RegisterResultResponse?>()

    fun registerUser(username: String, password: String, name: String, email: String) {
        val call = ApiConfig.getApiService().registerUser(username, password, name, email)

        call.enqueue(object : Callback<RegisterResultResponse> {
            override fun onResponse(
                call: Call<RegisterResultResponse>,
                response: Response<RegisterResultResponse>
            ) {
                if (response.isSuccessful) {
                    registerResult.postValue(response.body())
                } else {
                    // Handle unsuccessful response
                    registerResult.postValue(null)
                    Log.e("RegisterViewModel", "Unsuccessful response: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<RegisterResultResponse>, t: Throwable) {
                // Handle failure
                registerResult.postValue(null)
                Log.e("RegisterViewModel", "onFailure: ${t.message.toString()}")
            }
        })
    }
}