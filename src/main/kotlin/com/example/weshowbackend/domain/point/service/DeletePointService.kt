package com.example.weshowbackend.domain.point.service

import com.example.weshowbackend.domain.point.domain.repository.PointRepository
import com.example.weshowbackend.domain.point.facade.PointFacade
import com.example.weshowbackend.domain.product.domain.Product
import com.example.weshowbackend.domain.product.facade.ProductFacade
import com.example.weshowbackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors

@Service
class DeletePointService (
        private val pointRepository: PointRepository,
        private val pointFacade: PointFacade,
        private val userFacade: UserFacade,
        private val productFacade: ProductFacade
) {
    @Transactional
    fun delete(id: Long) {
        val point = pointFacade.getPoint(userFacade.getCurrentUser(), productFacade.getProduct(id))
        val product = productFacade.getProduct(id)

        product.minus(point)

        product.edit(getAverage(product))

        pointRepository.delete(
                point
        )
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