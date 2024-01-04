package com.example.projectmagang.network

import com.example.projectmagang.model.LoginResultResponse
import com.example.projectmagang.model.RegisterResultResponse
import com.example.projectmagang.model.UserResultResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

/** Raihan Chaira on 1/4/2024
 * raihanchaira21@gmail.com
 */
interface ApiService {
    @FormUrlEncoded
    @POST("login")
    fun loginUser(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<LoginResultResponse>

    @FormUrlEncoded
    @POST("user")
    fun registerUser(
        @Field("username") username : String,
        @Field("password") password: String,
        @Field("name") name : String,
        @Field("email") email : String
    ): Call<RegisterResultResponse>

    @GET("user")
    fun getUser(): Call<List<UserResultResponse>>
}