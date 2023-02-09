package com.example.weshowbackend.domain.product.domain.repository.vo

import com.example.weshowbackend.domain.point.domain.Point
import com.example.weshowbackend.domain.product.domain.type.Category
import com.querydsl.core.annotations.QueryProjection
import java.time.LocalDateTime

class ProductVo @QueryProjection constructor(
        val title: String,
        val price: Int,
        val comment: String,
        val category: Category,
        val createdAt: LocalDateTime,
        val point: List<Point>,
        val average: Float
)