package com.example.weshowbackend.domain.product.present.dto

data class ProductElementResponse (
        val images: List<String>,
        val title: String,
        val comment: String,
        val price: Int,
        val point: Float,
        val reviewCount: Int,
        val reviews: List<ReviewResponse>
)