package com.example.weshowbackend.global.error

import com.example.weshowbackend.global.error.custom.CustomException

class ErrorResponse<T> (
        val status: Int,
        val message: String,
) {
    companion object {
        fun of(e: CustomException): ErrorResponse<Unit> = ErrorResponse(
                status = e.status,
                message = e.errorMessage
        )

        fun valid(status: Int, message: String): ErrorResponse<Unit> = ErrorResponse(
                status = status,
                message = message
        )
    }
}