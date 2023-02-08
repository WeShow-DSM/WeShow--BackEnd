package com.example.weshowbackend.domain.image.domain.repository

import com.example.weshowbackend.domain.image.domain.Image
import com.example.weshowbackend.domain.product.domain.Product
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ImageRepository : CrudRepository<Image, Long> {
    fun findImagesByProduct(product: Product): List<Image>
}