package com.example.weshowbackend.domain.review.exception

import com.example.weshowbackend.global.error.custom.CustomException
import com.example.weshowbackend.global.error.custom.ErrorCode

object ReviewConflictException : CustomException(ErrorCode.REVIEW_CONFLICT_EXCEPTION) {
    val EXCEPTION = ReviewConflictException
}