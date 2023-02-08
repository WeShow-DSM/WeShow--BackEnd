package com.example.weshowbackend.domain.product.domain.repository

import com.example.weshowbackend.domain.product.domain.Product
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : CrudRepository<Product, Long> {
    fun findProductById(id: Long): Product?
}