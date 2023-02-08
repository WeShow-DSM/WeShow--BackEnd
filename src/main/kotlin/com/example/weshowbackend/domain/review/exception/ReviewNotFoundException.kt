package com.example.weshowbackend.domain.review.exception

import com.example.weshowbackend.global.error.custom.CustomException
import com.example.weshowbackend.global.error.custom.ErrorCode

object ReviewNotFoundException : CustomException(ErrorCode.REVIEW_NOT_FOUND_EXCEPTION) {
    val EXCEPTION = ReviewNotFoundException
}