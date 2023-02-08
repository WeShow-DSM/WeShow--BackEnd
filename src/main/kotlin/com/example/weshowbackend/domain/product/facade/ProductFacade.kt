package com.example.weshowbackend.domain.product.facade

import com.example.weshowbackend.domain.product.domain.Product
import com.example.weshowbackend.domain.product.domain.repository.ProductRepository
import com.example.weshowbackend.domain.product.exception.ProductNotFoundException
import org.springframework.stereotype.Component

@Component
class ProductFacade (
        private val productRepository: ProductRepository
) {

    fun getProduct(id: Long): Product {
        return productRepository.findProductById(id) ?: throw ProductNotFoundException.EXCEPTION
    }
}