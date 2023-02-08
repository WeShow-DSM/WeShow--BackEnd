package com.example.weshowbackend.domain.review.domain.repository

import com.example.weshowbackend.domain.review.domain.Review
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ReviewRepository : CrudRepository<Review, Long> {
}