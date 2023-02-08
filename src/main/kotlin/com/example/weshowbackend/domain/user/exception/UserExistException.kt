package com.example.weshowbackend.domain.user.exception

import com.example.weshowbackend.global.error.custom.CustomException
import com.example.weshowbackend.global.error.custom.ErrorCode

object UserExistException : CustomException(ErrorCode.USER_EXIST) {
    val EXCEPTION = UserExistException
}