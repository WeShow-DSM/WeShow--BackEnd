package com.example.weshowbackend.domain.product.present.dto

data class BasketElementResponse (
        val basketId: Long,
        val productId: Long,
        val productImage: String,
        val title: String,
        val price: Int,
        val count: Int,
        val productPrice: Int
)