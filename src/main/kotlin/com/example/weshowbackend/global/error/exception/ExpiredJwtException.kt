package com.example.weshowbackend.global.error.exception

import com.example.weshowbackend.global.error.custom.CustomException
import com.example.weshowbackend.global.error.custom.ErrorCode

object ExpiredJwtException : CustomException(ErrorCode.EXPIRED_JWT_EXCEPTION) {
    val EXCEPTION = ExpiredJwtException
}