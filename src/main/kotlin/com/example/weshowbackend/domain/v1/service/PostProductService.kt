package com.example.weshowbackend.domain.v1.service

import com.example.weshowbackend.domain.image.domain.Image
import com.example.weshowbackend.domain.image.domain.repository.ImageRepository
import com.example.weshowbackend.domain.product.domain.Product
import com.example.weshowbackend.domain.product.domain.repository.ProductRepository
import com.example.weshowbackend.domain.product.domain.type.Category
import com.example.weshowbackend.domain.user.domain.User
import com.example.weshowbackend.domain.user.facade.UserFacade
import com.example.weshowbackend.domain.v1.present.dto.ProductRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.*
import javax.validation.constraints.NotNull

@Service
class PostProductService (
        private val productRepository: ProductRepository,
        private val imageRepository: ImageRepository,
        private val userFacade: UserFacade
) {

    @Transactional
    fun execute(request: ProductRequest) {

        val product = productRepository.save(
                Product(
                        title = request.title,
                        price = request.price,
                        comment = request.content,
                        average = 0F,
                        category = Category.valueOf(request.category),
                        user = userFacade.getCurrentUser()
                )
        )

        request.images.stream()
                .map {
                    imageRepository.save(Image(it, product))
                }
    }
}