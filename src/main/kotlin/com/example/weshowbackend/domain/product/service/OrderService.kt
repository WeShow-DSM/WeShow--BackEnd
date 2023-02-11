package com.example.weshowbackend.domain.product.service

import com.example.weshowbackend.domain.basket.domain.repository.BasketRepository
import com.example.weshowbackend.domain.order.domain.Order
import com.example.weshowbackend.domain.order.domain.repository.OrderRepository
import com.example.weshowbackend.domain.product.facade.ProductFacade
import com.example.weshowbackend.domain.product.present.dto.OrderRequest
import com.example.weshowbackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderService (
        private val orderRepository: OrderRepository,
        private val basketRepository: BasketRepository,
        private val userFacade: UserFacade
) {

    @Transactional
    fun execute(request: OrderRequest) {
        request.products.forEach {
            orderRepository.save(
                    Order(
                            count = basketRepository.findBasketById(it).count,
                            user = userFacade.getCurrentUser(),
                            product = basketRepository.findBasketById(it).product
                    )
            )

            basketRepository.delete(basketRepository.findBasketById(it))
        }
    }
}