package com.example.weshowbackend.domain.point.exception

import com.example.weshowbackend.global.error.custom.CustomException
import com.example.weshowbackend.global.error.custom.ErrorCode

object PointConflictException : CustomException(ErrorCode.POINT_CONFLICT_EXCEPTION) {
    val EXCEPTION = PointConflictException
}