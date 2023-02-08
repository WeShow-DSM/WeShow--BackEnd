package com.example.weshowbackend.domain.user.exception

import com.example.weshowbackend.global.error.custom.CustomException
import com.example.weshowbackend.global.error.custom.ErrorCode

object UserNotFoundException : CustomException(ErrorCode.USER_NOT_FOUND_EXCEPTION) {
    val EXCEPTION = UserNotFoundException
}