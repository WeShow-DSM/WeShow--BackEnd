package com.example.weshowbackend.domain.v1.present.dto

data class ProductRequest (
        val title: String,
        val category: String,
        val price: Int,
        val images: List<String>,
        val content: String
)