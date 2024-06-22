package com.example.appslifebloodid.data.repository

import com.example.appslifebloodid.data.network.ApiService
import com.example.appslifebloodid.data.response.DataEvent
import retrofit2.Response

class EventRepository (private val apiService: ApiService) {
    suspend fun getLocations(): Response<List<DataEvent>> {
        return apiService.getLocations()
    }
}