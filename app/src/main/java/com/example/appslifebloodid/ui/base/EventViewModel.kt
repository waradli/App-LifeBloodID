package com.example.appslifebloodid.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.appslifebloodid.data.repository.ArticleRepository
import com.example.appslifebloodid.data.repository.EventRepository
import kotlinx.coroutines.Dispatchers

class EventViewModel (private val repository: EventRepository) : ViewModel() {
    val locations = liveData(Dispatchers.IO) {
        val response = repository.getLocations()
        emit(response.body() ?: emptyList())
    }
}