package com.example.weshowbackend.domain.auth.exception

import com.example.weshowbackend.global.error.custom.CustomException
import com.example.weshowbackend.global.error.custom.ErrorCode

object RefreshTokenNotFoundException : CustomException(ErrorCode.REFRESH_NOT_FOUND_EXCEPTION) {
    val EXCEPTION = RefreshTokenNotFoundException
}