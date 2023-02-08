package com.example.weshowbackend.domain.order.domain.repository

import com.example.weshowbackend.domain.order.domain.Order
import com.example.weshowbackend.domain.user.domain.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : CrudRepository<Order, Long> {
    fun findOrdersByUser(user: User): List<Order>
}