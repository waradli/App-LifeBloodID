package com.example.appslifebloodid.data.network

import com.example.appslifebloodid.data.response.Article
import com.example.appslifebloodid.data.response.AuthResponse
import com.example.appslifebloodid.data.response.DataEvent
import com.example.appslifebloodid.data.response.EventRegistrationRequest
import com.example.appslifebloodid.data.response.LoginRequest
import com.example.appslifebloodid.data.response.RegisterRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @POST("login")
    suspend fun login(@Body request: LoginRequest): Response<AuthResponse>

    @POST("register")
    suspend fun register(@Body request: RegisterRequest): Response<AuthResponse>

    @GET("articles")
    suspend fun getArticles(): Response<List<Article>>

    @GET("locations")
    suspend fun getLocations(): Response<List<DataEvent>>

    @GET("locations/{id}")
    suspend fun getLocationById(@Path("id") id: Int): Response<DataEvent>

    @POST("registrants")
    suspend fun registerEvent(@Body request: EventRegistrationRequest): Response<AuthResponse>
}