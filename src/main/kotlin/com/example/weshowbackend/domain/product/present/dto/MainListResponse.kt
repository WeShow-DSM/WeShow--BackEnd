package com.example.weshowbackend.domain.product.present.dto

data class MainListResponse (
        val todayProduct: String,
        val popularProduct: List<PopularProductResponse>,
        val randomProduct: List<RandomProductResponse>
)