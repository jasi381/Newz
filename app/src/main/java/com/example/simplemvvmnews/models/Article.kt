package com.example.simplemvvmnews.models

data class Article(
    val author: String,
    val publishedAt: String,
    val title: String,
    val url: String,
    val urlToImage: String
)