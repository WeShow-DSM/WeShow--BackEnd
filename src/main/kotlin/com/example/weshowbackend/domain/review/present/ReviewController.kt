package com.example.weshowbackend.domain.review.present

import com.example.weshowbackend.domain.review.present.dto.ReviewRequest
import com.example.weshowbackend.domain.review.service.DeleteReviewService
import com.example.weshowbackend.domain.review.service.EditReviewService
import com.example.weshowbackend.domain.review.service.SaveReviewService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/review")
class ReviewController (
        private val saveReviewService: SaveReviewService,
        private val editReviewService: EditReviewService,
        private val deleteReviewService: DeleteReviewService
) {

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    fun saveReview(@PathVariable("id") id: Long, @RequestBody request: ReviewRequest) {
        saveReviewService.saveReview(id, request)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun editReview(@PathVariable("id") id: Long, @RequestBody request: ReviewRequest) {
        editReviewService.editReview(id, request)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteReview(@PathVariable("id") id: Long) {
        deleteReviewService.delete(id)
    }
}