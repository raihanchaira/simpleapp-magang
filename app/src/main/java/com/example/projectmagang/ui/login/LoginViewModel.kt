package com.example.projectmagang.ui.login

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projectmagang.model.LoginResultResponse
import com.example.projectmagang.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/** Raihan Chaira on 1/4/2024
 * raihanchaira21@gmail.com
 */
class LoginViewModel : ViewModel() {

    val LoginResult = MutableLiveData<LoginResultResponse?>()

    fun loginUser(email : String, password : String) {
        LoginResult.value = null
        val call = ApiConfig.getApiService().loginUser(email, password)

        call.enqueue(object : Callback<LoginResultResponse> {
            override fun onResponse(call: Call<LoginResultResponse>, response: Response<LoginResultResponse>) {
                if (response.isSuccessful) {
                    LoginResult.postValue(response.body())
                } else {
                    Log.e(ContentValues.TAG, "Unsuccessful response: ${response.code()}, ${response.message()}")
                    LoginResult.postValue(LoginResultResponse(null, null, null))
                }
            }

            override fun onFailure(call: Call<LoginResultResponse>, t: Throwable) {
                Log.e(ContentValues.TAG, "onFailure : ${t.message.toString()}")
                LoginResult.postValue(LoginResultResponse(null, null, null))
            }
        })

    }
}