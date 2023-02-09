package com.example.weshowbackend.domain.v1.service

import com.example.weshowbackend.domain.product.domain.type.Category
import com.example.weshowbackend.domain.product.facade.ProductFacade
import com.example.weshowbackend.domain.v1.present.dto.ProductRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EditProductService (
        private val productFacade: ProductFacade
) {

    @Transactional
    fun execute(id: Long, request: ProductRequest) {
        val product = productFacade.getProduct(id)

        product.patchProduct(
                request.title,
                request.price,
                request.content,
                Category.valueOf(request.category)
        )
    }
}