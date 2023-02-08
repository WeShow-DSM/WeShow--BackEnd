package com.example.weshowbackend.global.error.exception

import com.example.weshowbackend.global.error.custom.CustomException
import com.example.weshowbackend.global.error.custom.ErrorCode

object InvalidJwtException : CustomException(ErrorCode.INVALID_JWT_EXCEPTION) {
    val EXCEPTION = InvalidJwtException
}