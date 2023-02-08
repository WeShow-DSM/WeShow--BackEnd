package com.example.weshowbackend.domain.point.exception

import com.example.weshowbackend.global.error.custom.CustomException
import com.example.weshowbackend.global.error.custom.ErrorCode

object PointNotFoundException : CustomException(ErrorCode.POINT_NOT_FOUND_EXCEPTION) {
    val EXCEPTION = PointNotFoundException
}