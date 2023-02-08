package com.example.weshowbackend.domain.review.service

import com.example.weshowbackend.domain.product.facade.ProductFacade
import com.example.weshowbackend.domain.review.facade.ReviewFacade
import com.example.weshowbackend.domain.review.present.dto.ReviewRequest
import com.example.weshowbackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EditReviewService (
        private val reviewFacade: ReviewFacade,
        private val userFacade: UserFacade,
        private val productFacade: ProductFacade
) {

    @Transactional
    fun editReview(id: Long, request: ReviewRequest) {
        reviewFacade.getReview(userFacade.getCurrentUser(), productFacade.getProduct(id)).editReview(request.comment)
    }
}