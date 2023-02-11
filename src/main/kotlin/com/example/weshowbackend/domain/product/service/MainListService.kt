package com.example.weshowbackend.domain.product.service

import com.example.weshowbackend.domain.image.domain.repository.ImageRepository
import com.example.weshowbackend.domain.image.facade.ImageFacade
import com.example.weshowbackend.domain.product.domain.repository.ProductRepository
import com.example.weshowbackend.domain.product.present.dto.MainListResponse
import com.example.weshowbackend.domain.product.present.dto.PopularProductResponse
import com.example.weshowbackend.domain.product.present.dto.RandomProductResponse
import com.example.weshowbackend.domain.review.domain.repository.ReviewRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors

@Service
class MainListService (
        private val productRepository: ProductRepository,
        private val imageFacade: ImageFacade,
        private val reviewRepository: ReviewRepository
) {

    @Transactional(readOnly = true)
    fun mainList():MainListResponse {
        val popularProducts = productRepository.randomProducts().stream()
                .map {
                    PopularProductResponse (
                            id = it.id,
                            productImage = imageFacade.getImage(it).url,
                            title = it.title,
                            price = it.price,
                            point = it.average,
                            reviewCount = reviewRepository.findReviewsByProduct(it).size
                    )
                }.collect(Collectors.toList())

        val randomProducts = productRepository.randomProducts().stream()
                .map {
                    RandomProductResponse(
                            id = it.id,
                            productImage = imageFacade.getImage(it).url,
                            title = it.title,
                            price = it.price,
                            point = it.average,
                            reviewCount = reviewRepository.findReviewsByProduct(it).size
                    )
                }.collect(Collectors.toList())

        return MainListResponse(
                todayProduct = imageFacade.getImage(productRepository.todayProduct()).url,
                popularProduct = popularProducts,
                randomProduct = randomProducts
        )
    }
}