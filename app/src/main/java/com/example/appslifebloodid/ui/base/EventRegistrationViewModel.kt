package com.example.appslifebloodid.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appslifebloodid.data.repository.EventRegistrationRepository
import kotlinx.coroutines.launch

class EventRegistrationViewModel(private val repository: EventRegistrationRepository) : ViewModel() {

    fun eventRegistration(
        fullName: String,
        address: String,
        dateOfBirth: String,
        gender: String,
        bloodType: String,
        phoneNumber: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        viewModelScope.launch {
            try {
                val response = repository.eventRegistration(fullName, address, dateOfBirth, gender, bloodType, phoneNumber)
                if (response.isSuccessful) {
                    onSuccess()
                } else {
                    onError(response.errorBody()?.string() ?: "An error occurred")
                }
            } catch (e: Exception) {
                onError(e.message ?: "An error occurred")
            }
        }
    }
}