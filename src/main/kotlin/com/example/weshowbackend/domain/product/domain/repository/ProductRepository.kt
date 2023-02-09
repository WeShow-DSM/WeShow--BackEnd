package com.example.weshowbackend.domain.product.domain.repository

import com.example.weshowbackend.domain.product.domain.Product
import com.example.weshowbackend.domain.product.domain.type.Category
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : CrudRepository<Product, Long>, CustomProductRepository {
    fun findProductById(id: Long): Product?

    fun findProductsByCategory(category: Category): List<Product>

    fun findProductsByTitleContains(title: String): List<Product>
}