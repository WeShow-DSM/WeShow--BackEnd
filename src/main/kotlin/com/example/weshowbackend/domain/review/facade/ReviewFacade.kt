package com.example.weshowbackend.domain.review.facade

import com.example.weshowbackend.domain.product.domain.Product
import com.example.weshowbackend.domain.review.domain.Review
import com.example.weshowbackend.domain.review.domain.repository.ReviewRepository
import com.example.weshowbackend.domain.review.exception.ReviewNotFoundException
import com.example.weshowbackend.domain.user.domain.User
import org.springframework.stereotype.Component

@Component
class ReviewFacade (
        private val reviewRepository: ReviewRepository
) {

    fun getReview(user: User, product: Product): Review {
        return reviewRepository.findReviewByUserAndProduct(user, product) ?: throw ReviewNotFoundException.EXCEPTION
    }
}