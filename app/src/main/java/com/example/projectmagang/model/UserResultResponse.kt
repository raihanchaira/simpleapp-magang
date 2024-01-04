package com.example.projectmagang.model

/** Raihan Chaira on 1/4/2024
 * raihanchaira21@gmail.com
 */
import com.google.gson.annotations.SerializedName


class UserResultResponse(
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("username")
    val username: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String
)
