package com.example.weshowbackend.domain.v1.service

import com.example.weshowbackend.domain.image.facade.ImageFacade
import com.example.weshowbackend.domain.product.domain.repository.ProductRepository
import com.example.weshowbackend.domain.review.domain.repository.ReviewRepository
import com.example.weshowbackend.domain.user.facade.UserFacade
import com.example.weshowbackend.domain.v1.present.dto.MyPageElementResponse
import com.example.weshowbackend.domain.v1.present.dto.MyPageResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors

@Service
class MyProductService (
        private val productRepository: ProductRepository,
        private val userFacade: UserFacade,
        private val imageFacade: ImageFacade,
        private val reviewRepository: ReviewRepository
) {

    @Transactional(readOnly = true)
    fun myPage(): MyPageResponse {

        val list = productRepository.findProductsByUser(userFacade.getCurrentUser()).stream()
                .map {
                    MyPageElementResponse(
                            id = it.id,
                            price = it.price,
                            image = imageFacade.getImage(it).url,
                            point = it.average,
                            reviewCount = reviewRepository.findReviewsByProduct(it).size,
                            title = it.title
                    )
                }.collect(Collectors.toList())

        return MyPageResponse(
                products = list
        )
    }
}