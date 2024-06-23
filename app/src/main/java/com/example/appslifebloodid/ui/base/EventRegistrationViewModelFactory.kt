package com.example.appslifebloodid.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appslifebloodid.data.repository.EventRegistrationRepository

class EventRegistrationViewModelFactory(private val repository: EventRegistrationRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EventRegistrationViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return EventRegistrationViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}