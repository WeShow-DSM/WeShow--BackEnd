package com.example.weshowbackend.domain.product.exception

import com.example.weshowbackend.global.error.custom.CustomException
import com.example.weshowbackend.global.error.custom.ErrorCode

object ProductNotFoundException : CustomException(ErrorCode.PRODUCT_NOT_FOUND_EXCEPTION) {
    val EXCEPTION = ProductNotFoundException
}