package com.example.appslifebloodid.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.appslifebloodid.data.repository.ArticleRepository
import com.example.appslifebloodid.data.response.Article
import com.example.appslifebloodid.data.response.DataEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticleViewModel(private val repository: ArticleRepository) : ViewModel() {
    val articles = liveData(Dispatchers.IO) {
        val response = repository.getArticles()
        emit(response.body() ?: emptyList())
    }

    private val _articleDetail = MutableStateFlow<Article?>(null)
    val articleDetail: StateFlow<Article?> = _articleDetail

    fun getLocationDetail(id: Int) {
        viewModelScope.launch {
            val response = repository.getArticleById(id)
            if (response.isSuccessful) {
                _articleDetail.value = response.body()
            } else {
                // Handle error appropriately
                _articleDetail.value = null
            }
        }
    }
}