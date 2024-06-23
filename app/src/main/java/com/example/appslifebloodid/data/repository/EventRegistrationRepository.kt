package com.example.appslifebloodid.data.repository

import com.example.appslifebloodid.data.network.ApiService
import com.example.appslifebloodid.data.response.EventRegistrationRequest

class EventRegistrationRepository(private val apiService: ApiService) {

    suspend fun eventRegistration(
        fullName: String,
        address: String,
        dateOfBirth: String,
        gender: String,
        bloodType: String,
        phoneNumber: String
    ) = apiService.registerEvent(
        EventRegistrationRequest(
            id = 0, // ID biasanya diisi oleh server, kita set defaultnya ke 0
            full_name = fullName,
            address = address,
            birth_date = dateOfBirth,
            gender = gender,
            blood_type = bloodType,
            phone_number = phoneNumber
        )
    )
}