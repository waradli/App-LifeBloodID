package com.example.appslifebloodid.data.network

import com.example.appslifebloodid.data.response.AuthResponse
import com.example.appslifebloodid.data.response.LoginRequest
import com.example.appslifebloodid.data.response.RegisterRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("login")
    suspend fun login(@Body request: LoginRequest): Response<AuthResponse>

    @POST("register")
    suspend fun register(@Body request: RegisterRequest): Response<AuthResponse>
}