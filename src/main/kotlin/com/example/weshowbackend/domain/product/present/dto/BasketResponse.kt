package com.example.weshowbackend.domain.product.present.dto

data class BasketResponse (
        val products: List<BasketElementResponse>,
        val totalPrice: Int
)