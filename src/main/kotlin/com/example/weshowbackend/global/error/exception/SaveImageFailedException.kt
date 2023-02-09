package com.example.weshowbackend.global.error.exception

import com.example.weshowbackend.global.error.custom.CustomException
import com.example.weshowbackend.global.error.custom.ErrorCode

object SaveImageFailedException : CustomException(ErrorCode.SAVE_IMAGE_FAILED_EXCEPTION) {
    val EXCEPTION = SaveImageFailedException
}