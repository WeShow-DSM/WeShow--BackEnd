package com.example.weshowbackend.domain.point.service

import com.example.weshowbackend.domain.point.domain.Point
import com.example.weshowbackend.domain.point.domain.repository.PointRepository
import com.example.weshowbackend.domain.point.exception.PointConflictException
import com.example.weshowbackend.domain.point.present.dto.PointRequest
import com.example.weshowbackend.domain.product.facade.ProductFacade
import com.example.weshowbackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SavePointService (
        private val userFacade: UserFacade,
        private val productFacade: ProductFacade,
        private val pointRepository: PointRepository
) {

    @Transactional
    fun save(id: Long, request: PointRequest) {
        val user = userFacade.getCurrentUser()
        val product = productFacade.getProduct(id)

        pointRepository.findPointByUserAndProduct(user, product).let {
            if(it == null) { throw PointConflictException.EXCEPTION }
        }

        val point = Point(
                point = request.point,
                user = user,
                product = product
        )

        pointRepository.save(point)
    }
}