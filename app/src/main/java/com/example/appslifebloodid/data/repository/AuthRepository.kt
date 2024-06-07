package com.example.appslifebloodid.data.repository

import com.example.appslifebloodid.data.network.RetrofitInstance
import com.example.appslifebloodid.data.response.AuthResponse
import com.example.appslifebloodid.data.response.LoginRequest
import com.example.appslifebloodid.data.response.RegisterRequest

class AuthRepository {
    private val api = RetrofitInstance.api

    suspend fun login(request: LoginRequest): AuthResponse? {
        val response = api.login(request)
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }

    suspend fun register(request: RegisterRequest): AuthResponse? {
        val response = api.register(request)
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }
}