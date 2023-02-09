package com.example.weshowbackend.domain.v1.present.dto

import com.example.weshowbackend.domain.point.domain.Point

data class MyPageElementResponse(
        val id: Long,
        val price: Int,
        val image: String,
        val point: Float,
        val reviewCount: Int,
        val title: String
)
