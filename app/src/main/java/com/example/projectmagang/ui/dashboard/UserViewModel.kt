package com.example.projectmagang.ui.dashboard

/** Raihan Chaira on 1/4/2024
 * raihanchaira21@gmail.com
 */
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projectmagang.model.UserResultResponse
import com.example.projectmagang.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel : ViewModel() {

    private val _user = MutableLiveData<List<UserResultResponse>>()
    val user: LiveData<List<UserResultResponse>> = _user

    init {
        getUserList()
    }

    fun getUserList() {
        val call = ApiConfig.getApiService().getUser()

        call.enqueue(object : Callback<List<UserResultResponse>> {
            override fun onResponse(
                call: Call<List<UserResultResponse>>,
                response: Response<List<UserResultResponse>>
            ) {
                if (response.isSuccessful) {
                    _user.postValue(response.body())
                } else {
                    _user.postValue(null)
                }
            }

            override fun onFailure(call: Call<List<UserResultResponse>>, t: Throwable) {
                _user.postValue(null)
            }
        })
    }
}
