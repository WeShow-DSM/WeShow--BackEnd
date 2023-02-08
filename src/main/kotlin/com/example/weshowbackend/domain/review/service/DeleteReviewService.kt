package com.example.weshowbackend.domain.review.service

import com.example.weshowbackend.domain.product.facade.ProductFacade
import com.example.weshowbackend.domain.review.domain.repository.ReviewRepository
import com.example.weshowbackend.domain.review.facade.ReviewFacade
import com.example.weshowbackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DeleteReviewService (
        private val reviewFacade: ReviewFacade,
        private val reviewRepository: ReviewRepository,
        private val userFacade: UserFacade,
        private val productFacade: ProductFacade
) {

    @Transactional
    fun delete(id: Long) {
        reviewRepository.delete(
                reviewFacade.getReview(userFacade.getCurrentUser(), productFacade.getProduct(id))
        )
    }
}