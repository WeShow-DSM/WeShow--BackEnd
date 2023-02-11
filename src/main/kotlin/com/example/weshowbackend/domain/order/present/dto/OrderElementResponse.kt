package com.example.weshowbackend.domain.order.present.dto

data class OrderElementResponse (
        val productId: Long,
        val title: String,
        val price: Int,
        val count: Int,
        val productImage: String
)