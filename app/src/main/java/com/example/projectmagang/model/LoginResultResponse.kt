package com.example.projectmagang.model

import com.google.gson.annotations.SerializedName

/** Raihan Chaira on 1/4/2024
 * raihanchaira21@gmail.com
 */
class LoginResultResponse(
    @field:SerializedName("username")
    val username: String?,
    @field:SerializedName("name")
    val name: String?,
    @field:SerializedName("email")
    val email: String?
)