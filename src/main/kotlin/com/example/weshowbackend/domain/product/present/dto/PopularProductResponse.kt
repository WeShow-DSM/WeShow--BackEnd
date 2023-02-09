package com.example.weshowbackend.domain.product.present.dto

data class PopularProductResponse (
        val id: Long,
        val productImage: String,
        val comment: String,
        val price: Int,
        val point: Float,
        val reviewCount: Int
)