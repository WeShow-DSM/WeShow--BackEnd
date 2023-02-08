package com.example.weshowbackend.domain.point.service

import com.example.weshowbackend.domain.point.domain.repository.PointRepository
import com.example.weshowbackend.domain.point.facade.PointFacade
import com.example.weshowbackend.domain.product.facade.ProductFacade
import com.example.weshowbackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DeletePointService (
        private val pointRepository: PointRepository,
        private val pointFacade: PointFacade,
        private val userFacade: UserFacade,
        private val productFacade: ProductFacade
) {
    @Transactional
    fun delete(id: Long) {
        pointRepository.delete(
                pointFacade.getPoint(userFacade.getCurrentUser(), productFacade.getProduct(id))
        )
    }
}