package com.example.weshowbackend.domain.point.service

import com.example.weshowbackend.domain.point.facade.PointFacade
import com.example.weshowbackend.domain.point.present.dto.PointRequest
import com.example.weshowbackend.domain.product.facade.ProductFacade
import com.example.weshowbackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EditPointService (
        private val pointFacade: PointFacade,
        private val userFacade: UserFacade,
        private val productFacade: ProductFacade
) {
    @Transactional
    fun edit(id: Long, request: PointRequest) {
        pointFacade.getPoint(userFacade.getCurrentUser(), productFacade.getProduct(id)).editPoint(request.point)
    }
}