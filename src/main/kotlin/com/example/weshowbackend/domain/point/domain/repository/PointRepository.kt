package com.example.weshowbackend.domain.point.domain.repository

import com.example.weshowbackend.domain.point.domain.Point
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PointRepository : CrudRepository<Point, Long> {
}