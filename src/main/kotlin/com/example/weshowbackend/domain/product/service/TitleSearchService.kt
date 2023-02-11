package com.example.weshowbackend.domain.product.service

import com.example.weshowbackend.domain.image.facade.ImageFacade
import com.example.weshowbackend.domain.product.domain.repository.ProductRepository
import com.example.weshowbackend.domain.product.domain.type.Category
import com.example.weshowbackend.domain.product.present.dto.CategorySearchResponse
import com.example.weshowbackend.domain.product.present.dto.PopularProductResponse
import com.example.weshowbackend.domain.record.domain.Record
import com.example.weshowbackend.domain.record.domain.repository.RecordRepository
import com.example.weshowbackend.domain.review.domain.repository.ReviewRepository
import com.example.weshowbackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors

@Service
class TitleSearchService (
        private val productRepository: ProductRepository,
        private val imageFacade: ImageFacade,
        private val reviewRepository: ReviewRepository,
        private val recordRepository: RecordRepository,
        private val userFacade: UserFacade
) {

    @Transactional
    fun execute(title: String): CategorySearchResponse {

        val list = productRepository.findProductsByTitleContains(title).stream()
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

        recordRepository.save(
                Record(
                        content = title,
                        user =  userFacade.getCurrentUser()
                )
        )

        return CategorySearchResponse(
                products = list
        )
    }
}