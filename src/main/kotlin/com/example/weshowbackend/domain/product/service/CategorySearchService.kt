package com.example.weshowbackend.domain.product.service

import com.example.weshowbackend.domain.image.facade.ImageFacade
import com.example.weshowbackend.domain.product.domain.repository.ProductRepository
import com.example.weshowbackend.domain.product.domain.type.Category
import com.example.weshowbackend.domain.product.present.dto.CategorySearchResponse
import com.example.weshowbackend.domain.product.present.dto.PopularProductResponse
import com.example.weshowbackend.domain.review.domain.repository.ReviewRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors

@Service
class CategorySearchService (
        private val productRepository: ProductRepository,
        private val imageFacade: ImageFacade,
        private val reviewRepository: ReviewRepository
) {

    @Transactional(readOnly = true)
    fun execute(category: String): CategorySearchResponse {

        val list = productRepository.findProductsByCategory(Category.valueOf(category)).stream()
                .map {
                    PopularProductResponse (
                            id = it.id,
                            productImage = imageFacade.getImage(it).url,
                            comment = it.comment,
                            price = it.price,
                            point = it.average,
                            reviewCount = reviewRepository.findReviewsByProduct(it).size
                    )
                }.collect(Collectors.toList())

        return CategorySearchResponse(
                products = list
        )
    }
}