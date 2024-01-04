package com.example.projectmagang.ui.dashboard

/** Raihan Chaira on 1/4/2024
 * raihanchaira21@gmail.com
 */
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projectmagang.model.UserResultResponse
import com.example.projectmagang.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel : ViewModel() {

    private val userListResult = MutableLiveData<UserResultResponse>()

    fun getUserList() {
        val call = ApiConfig.getApiService().getUser()

        call.enqueue(object : Callback<UserResultResponse> {
            override fun onResponse(
                call: Call<UserResultResponse>,
                response: Response<UserResultResponse>
            ) {
                if (response.isSuccessful) {
                    userListResult.postValue(response.body())
                } else {
                    // Handle unsuccessful response
                    userListResult.postValue(null)
                }            }

            override fun onFailure(call: Call<UserResultResponse>, t: Throwable) {
                userListResult.postValue(null)
            }
        })
    }

    fun getUserListResult() = userListResult
}
