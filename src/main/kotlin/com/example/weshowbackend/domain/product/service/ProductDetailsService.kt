package com.example.weshowbackend.domain.product.service

import com.example.weshowbackend.domain.image.domain.repository.ImageRepository
import com.example.weshowbackend.domain.product.domain.repository.ProductRepository
import com.example.weshowbackend.domain.product.facade.ProductFacade
import com.example.weshowbackend.domain.product.present.dto.ProductElementResponse
import com.example.weshowbackend.domain.product.present.dto.ReviewResponse
import com.example.weshowbackend.domain.review.domain.repository.ReviewRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors

@Service
class ProductDetailsService (
        private val productFacade: ProductFacade,
        private val reviewRepository: ReviewRepository,
        private val imageRepository: ImageRepository
) {

    @Transactional(readOnly = true)
    fun execute(id: Long): ProductElementResponse {
        val product = productFacade.getProduct(id)

        val list = imageRepository.findImagesByProduct(product).stream()
                .map {
                    it.url
                }
                .collect(Collectors.toList())

        val reviews = reviewRepository.findReviewsByProduct(product).stream()
                .map {
                    ReviewResponse(
                            id = it.id,
                            nick = it.user.nickname,
                            comment = it.comment
                    )
                }
                .collect(Collectors.toList())

        return ProductElementResponse(
                images = list,
                title = product.title,
                comment = product.comment,
                price = product.price,
                point = product.average,
                reviewCount = reviewRepository.findReviewsByProduct(product).size,
                reviews = reviews
        )
    }
}