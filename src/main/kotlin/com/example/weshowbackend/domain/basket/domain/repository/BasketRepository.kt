package com.example.weshowbackend.domain.basket.domain.repository

import com.example.weshowbackend.domain.basket.domain.Basket
import com.example.weshowbackend.domain.product.domain.Product
import com.example.weshowbackend.domain.user.domain.User
import org.springframework.data.repository.CrudRepository

interface BasketRepository : CrudRepository<Basket, Long> {
    fun findBasketByUserAndProduct(user: User, product: Product): Basket?

    fun findBasketsByUser(user: User): List<Basket>

    fun findBasketById(id: Long): Basket
}