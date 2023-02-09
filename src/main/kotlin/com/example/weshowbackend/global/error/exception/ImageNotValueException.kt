package com.example.weshowbackend.global.error.exception

import com.example.weshowbackend.global.error.custom.CustomException
import com.example.weshowbackend.global.error.custom.ErrorCode

object ImageNotValueException : CustomException(ErrorCode.IMAGE_NOT_VALUE_EXCEPTION) {
    val EXCEPTION = ImageNotValueException
}