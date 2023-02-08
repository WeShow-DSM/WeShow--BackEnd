package com.example.weshowbackend.global.error.exception

import com.example.weshowbackend.global.error.custom.CustomException
import com.example.weshowbackend.global.error.custom.ErrorCode

object InternalServerException : CustomException(ErrorCode.INTERNAL_SERVER_ERROR) {
    val EXCEPTION = InternalServerException
}