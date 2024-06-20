package com.example.appslifebloodid.data.response

data class Article (
    val id: Int,
    val title:String,
    val content:String,
    val author:String,
    val image_url:String,
    val created_at:String
)