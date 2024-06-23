package com.example.appslifebloodid.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appslifebloodid.data.repository.EventRepository

class EventViewModelFactory(private val repository: EventRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EventViewModel::class.java)) {
            return EventViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}