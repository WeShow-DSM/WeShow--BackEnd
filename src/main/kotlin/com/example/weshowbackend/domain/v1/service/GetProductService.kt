package com.example.weshowbackend.domain.v1.service

import com.example.weshowbackend.domain.image.domain.repository.ImageRepository
import com.example.weshowbackend.domain.product.facade.ProductFacade
import com.example.weshowbackend.domain.review.domain.repository.ReviewRepository
import com.example.weshowbackend.domain.v1.present.dto.GetOneResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors

@Service
class GetProductService (
        private val productFacade: ProductFacade,
        private val imageRepository: ImageRepository,
        private val reviewRepository: ReviewRepository
) {

    @Transactional(readOnly = true)
    fun execute(id: Long): GetOneResponse {
        val product = productFacade.getProduct(id)

        val list = imageRepository.findImagesByProduct(product).stream()
                .map {
                    it.url
                }.collect(Collectors.toList())

        return GetOneResponse(
                id = product.id,
                name = product.user.nickname,
                price = product.price,
                images = list,
                point = product.average,
                reviewCount = reviewRepository.findReviewsByProduct(product).size,
                title = product.title,
                content = product.comment
        )
    }
}