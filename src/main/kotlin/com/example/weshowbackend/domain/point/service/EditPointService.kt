package com.example.weshowbackend.domain.point.service

import com.example.weshowbackend.domain.point.facade.PointFacade
import com.example.weshowbackend.domain.point.present.dto.PointRequest
import com.example.weshowbackend.domain.product.domain.Product
import com.example.weshowbackend.domain.product.facade.ProductFacade
import com.example.weshowbackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors

@Service
class EditPointService (
        private val pointFacade: PointFacade,
        private val userFacade: UserFacade,
        private val productFacade: ProductFacade
) {
    @Transactional
    fun edit(id: Long, request: PointRequest) {
        val point = pointFacade.getPoint(userFacade.getCurrentUser(), productFacade.getProduct(id))
        point.editPoint(request.point)

        productFacade.getProduct(id).edit(getAverage(product = productFacade.getProduct(id)))
    }

    private fun getAverage(product: Product): Float {
        val list = product.point.stream()
                .map {
                    it.point
                }
                .collect(Collectors.toList())

        return list.average().toFloat()
    }
}