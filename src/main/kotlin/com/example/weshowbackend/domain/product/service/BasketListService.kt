package com.example.weshowbackend.domain.product.service

import com.example.weshowbackend.domain.basket.domain.repository.BasketRepository
import com.example.weshowbackend.domain.image.facade.ImageFacade
import com.example.weshowbackend.domain.product.domain.repository.ProductRepository
import com.example.weshowbackend.domain.product.present.dto.BasketElementResponse
import com.example.weshowbackend.domain.product.present.dto.BasketResponse
import com.example.weshowbackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors

@Service
class BasketListService (
        private val basketRepository: BasketRepository,
        private val userFacade: UserFacade,
        private val imageFacade: ImageFacade
) {

    @Transactional(readOnly = true)
    fun execute(): BasketResponse {
        var total: Int = 0

        val list = basketRepository.findBasketsByUser(userFacade.getCurrentUser()).stream()
                .map {
                    BasketElementResponse(
                            basketId = it.id,
                            productId = it.product.id,
                            productImage = imageFacade.getImage(it.product).url,
                            title = it.product.title,
                            price = it.product.price,
                            count = it.count,
                            productPrice = (it.count * it.product.price)
                    )
                }.collect(Collectors.toList())

        basketRepository.findBasketsByUser(userFacade.getCurrentUser()).stream()
                .map {
                    total += it.count * it.product.price
                }

        basketRepository.findBasketsByUser(userFacade.getCurrentUser()).forEach {
            total += it.count *  it.product.price
        }

        return BasketResponse(
                products = list,
                totalPrice = total
        )
    }
}