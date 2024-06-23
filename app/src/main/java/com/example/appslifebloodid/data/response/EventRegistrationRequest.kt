package com.example.appslifebloodid.data.response

data class EventRegistrationRequest(
    val id: Int,
    val full_name: String,
    val address: String,
    val birth_date: String,
    val gender: String,
    val blood_type: String,
    val phone_number: String
)