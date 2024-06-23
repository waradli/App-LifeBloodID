package com.example.appslifebloodid.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.appslifebloodid.data.repository.ArticleRepository
import com.example.appslifebloodid.data.repository.EventRepository
import com.example.appslifebloodid.data.response.DataEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response

class EventViewModel(private val repository: EventRepository) : ViewModel() {
    val locations = liveData(Dispatchers.IO) {
        val response = repository.getLocations()
        emit(response.body() ?: emptyList())
    }

    private val _locationDetail = MutableStateFlow<DataEvent?>(null)
    val locationDetail: StateFlow<DataEvent?> = _locationDetail

    fun getLocationDetail(id: Int) {
        viewModelScope.launch {
            val response = repository.getLocationById(id)
            if (response.isSuccessful) {
                _locationDetail.value = response.body()
            } else {
                // Handle error appropriately
                _locationDetail.value = null
            }
        }
    }
}