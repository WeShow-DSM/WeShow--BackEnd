package com.example.weshowbackend.domain.order.present

import com.example.weshowbackend.domain.order.present.dto.OrderListResponse
import com.example.weshowbackend.domain.order.service.OrderListService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/order")
class OrderController (
        private val orderListService: OrderListService
) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun orderList(): OrderListResponse {
        return orderListService.orderList()
    }
}