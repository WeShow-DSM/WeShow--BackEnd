package com.example.weshowbackend.domain.order.service

import com.example.weshowbackend.domain.image.facade.ImageFacade
import com.example.weshowbackend.domain.order.domain.repository.OrderRepository
import com.example.weshowbackend.domain.order.present.dto.OrderElementResponse
import com.example.weshowbackend.domain.order.present.dto.OrderListResponse
import com.example.weshowbackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors

@Service
class OrderListService (
        private val orderRepository: OrderRepository,
        private val userFacade: UserFacade,
        private val imageFacade: ImageFacade
) {

    @Transactional(readOnly = true)
    fun orderList(): OrderListResponse {
        val orderList = orderRepository.findOrdersByUser(userFacade.getCurrentUser()).stream()
                .map {
                    OrderElementResponse(
                            title = it.product.title,
                            price = it.product.price,
                            count = it.count,
                            productImage = imageFacade.getImage(it.product).url
                    )
                }
                .collect(Collectors.toList())

        return OrderListResponse(
                orders = orderList
        )
    }
}