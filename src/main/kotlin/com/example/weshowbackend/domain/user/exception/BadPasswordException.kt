package com.example.weshowbackend.domain.user.exception

import com.example.weshowbackend.global.error.custom.CustomException
import com.example.weshowbackend.global.error.custom.ErrorCode

object BadPasswordException : CustomException(ErrorCode.BAD_PASSWORD_EXCEPTION) {
    val EXCEPTION = BadPasswordException
}