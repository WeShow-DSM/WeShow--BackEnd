package com.example.weshowbackend.domain.review.service

import com.example.weshowbackend.domain.product.facade.ProductFacade
import com.example.weshowbackend.domain.review.domain.Review
import com.example.weshowbackend.domain.review.domain.repository.ReviewRepository
import com.example.weshowbackend.domain.review.exception.ReviewConflictException
import com.example.weshowbackend.domain.review.present.dto.ReviewRequest
import com.example.weshowbackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SaveReviewService (
        private val reviewRepository: ReviewRepository,
        private val productFacade: ProductFacade,
        private val userFacade: UserFacade
) {

    @Transactional
    fun saveReview(id: Long, request: ReviewRequest) {
        val user = userFacade.getCurrentUser()
        val product = productFacade.getProduct(id)

        reviewRepository.findReviewByUserAndProduct(user, product).let {
            if(it == null) { throw ReviewConflictException.EXCEPTION }
        }

        val review = Review(
                comment = request.comment,
                user = user,
                product = product
        )

        reviewRepository.save(review)
    }
}