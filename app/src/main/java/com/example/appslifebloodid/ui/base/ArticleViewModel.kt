package com.example.appslifebloodid.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.appslifebloodid.data.repository.ArticleRepository
import kotlinx.coroutines.Dispatchers

class ArticleViewModel(private val repository: ArticleRepository) : ViewModel() {
    val articles = liveData(Dispatchers.IO) {
        val response = repository.getArticles()
        emit(response.body() ?: emptyList())
    }
}