package com.example.weshowbackend.domain.v1.service

import com.example.weshowbackend.domain.image.domain.Image
import com.example.weshowbackend.domain.image.domain.repository.ImageRepository
import com.example.weshowbackend.domain.product.domain.type.Category
import com.example.weshowbackend.domain.product.facade.ProductFacade
import com.example.weshowbackend.domain.v1.present.dto.ProductRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EditProductService (
        private val productFacade: ProductFacade,
        private val imageRepository: ImageRepository
) {

    @Transactional
    fun execute(id: Long, request: ProductRequest) {
        val product = productFacade.getProduct(id)

        imageRepository.deleteAllByProduct(product)

        request.images.forEach {
            imageRepository.save(
                    Image(
                            it, product
                    )
            )
        }


        product.patchProduct(
                request.title,
                request.price,
                request.content,
                Category.valueOf(request.category)
        )
    }
}