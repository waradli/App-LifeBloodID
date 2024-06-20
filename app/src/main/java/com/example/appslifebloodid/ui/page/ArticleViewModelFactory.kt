package com.example.appslifebloodid.ui.page

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appslifebloodid.data.repository.ArticleRepository
import com.example.appslifebloodid.ui.base.ArticleViewModel

class ArticleViewModelFactory(private val repository: ArticleRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ArticleViewModel::class.java)) {
            return ArticleViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}