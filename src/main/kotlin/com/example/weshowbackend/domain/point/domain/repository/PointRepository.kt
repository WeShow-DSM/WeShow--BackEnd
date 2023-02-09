package com.example.weshowbackend.domain.point.domain.repository

import com.example.weshowbackend.domain.point.domain.Point
import com.example.weshowbackend.domain.product.domain.Product
import com.example.weshowbackend.domain.user.domain.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PointRepository : CrudRepository<Point, Long> {
    fun findPointByUserAndProduct(user: User, product: Product): Point?

    fun findPointsByProduct(product: Product): List<Point>
}