package com.example.weshowbackend.domain.product.domain.repository

import com.example.weshowbackend.domain.product.domain.Product

interface CustomProductRepository {
    fun todayProduct(): Product

    fun popularProducts(): List<Product>

    fun randomProducts(): List<Product>
}