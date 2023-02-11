package com.example.weshowbackend.domain.v1.service

import com.example.weshowbackend.domain.image.domain.repository.ImageRepository
import com.example.weshowbackend.domain.order.domain.repository.OrderRepository
import com.example.weshowbackend.domain.point.domain.repository.PointRepository
import com.example.weshowbackend.domain.product.domain.repository.ProductRepository
import com.example.weshowbackend.domain.product.facade.ProductFacade
import com.example.weshowbackend.domain.review.domain.repository.ReviewRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors

@Service
class DeleteProductService (
        private val productRepository: ProductRepository,
        private val orderRepository: OrderRepository,
        private val imageRepository: ImageRepository,
        private val pointRepository: PointRepository,
        private val reviewRepository: ReviewRepository,
        private val productFacade: ProductFacade
) {

    @Transactional
    fun execute(id: Long) {
        val product = productFacade.getProduct(id)

        orderRepository.deleteAllByProduct(product)
        imageRepository.deleteAllByProduct(product)
        reviewRepository.deleteAllByProduct(product)
        pointRepository.deleteAllByProduct(product)

        productRepository.delete(product)
    }
}