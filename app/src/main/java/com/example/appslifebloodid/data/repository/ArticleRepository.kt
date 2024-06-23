package com.example.appslifebloodid.data.repository

import com.example.appslifebloodid.data.network.ApiService
import com.example.appslifebloodid.data.response.Article
import retrofit2.Response

class ArticleRepository(private val apiService: ApiService) {
    suspend fun getArticles(): Response<List<Article>> {
        return apiService.getArticles()
    }

    suspend fun getArticleById(id: Int): Response<Article> {
        return apiService.getArticleById(id)
    }
}