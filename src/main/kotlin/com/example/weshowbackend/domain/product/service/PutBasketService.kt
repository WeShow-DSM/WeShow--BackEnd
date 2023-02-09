package com.example.weshowbackend.domain.product.service

import com.example.weshowbackend.domain.basket.domain.Basket
import com.example.weshowbackend.domain.basket.domain.repository.BasketRepository
import com.example.weshowbackend.domain.product.facade.ProductFacade
import com.example.weshowbackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PutBasketService (
        private val basketRepository: BasketRepository,
        private val userFacade: UserFacade,
        private val productFacade: ProductFacade
) {

    @Transactional
    fun execute(productId: Long, count: Int) {
        basketRepository.save(
                Basket(
                        count = count,
                        user = userFacade.getCurrentUser(),
                        product = productFacade.getProduct(productId)
                )
        )
    }
}