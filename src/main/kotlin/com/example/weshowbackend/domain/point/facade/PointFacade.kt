package com.example.weshowbackend.domain.point.facade

import com.example.weshowbackend.domain.point.domain.Point
import com.example.weshowbackend.domain.point.domain.repository.PointRepository
import com.example.weshowbackend.domain.point.exception.PointNotFoundException
import com.example.weshowbackend.domain.product.domain.Product
import com.example.weshowbackend.domain.user.domain.User
import org.springframework.stereotype.Component

@Component
class PointFacade (
        private val pointRepository: PointRepository
) {

    fun getPoint(user: User, product: Product): Point {
        return pointRepository.findPointByUserAndProduct(user, product) ?: throw PointNotFoundException.EXCEPTION
    }
}