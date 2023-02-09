package com.example.weshowbackend.domain.v1.present.dto

data class GetOneResponse (
        val id: Long,
        val name: String,
        val price: Int,
        val images: List<String>,
        val point: Float,
        val reviewCount: Int,
        val title: String,
        val content: String
)