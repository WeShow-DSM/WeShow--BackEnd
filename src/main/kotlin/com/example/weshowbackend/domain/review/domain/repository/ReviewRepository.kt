package com.example.weshowbackend.domain.review.domain.repository

import com.example.weshowbackend.domain.product.domain.Product
import com.example.weshowbackend.domain.review.domain.Review
import com.example.weshowbackend.domain.user.domain.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ReviewRepository : CrudRepository<Review, Long> {
    fun findReviewById(id: Long): Review?

    fun findReviewByUserAndProduct(user: User, product: Product): Review?

    fun findReviewsByProduct(product: Product): List<Review>
}