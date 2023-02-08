package com.example.weshowbackend.domain.image.facade

import com.example.weshowbackend.domain.image.domain.Image
import com.example.weshowbackend.domain.image.domain.repository.ImageRepository
import com.example.weshowbackend.domain.product.domain.Product
import org.springframework.stereotype.Component

@Component
class ImageFacade (
        private val imageRepository: ImageRepository
) {

    fun getImage(product: Product): Image {
        return imageRepository.findImagesByProduct(product)[0]
    }
}