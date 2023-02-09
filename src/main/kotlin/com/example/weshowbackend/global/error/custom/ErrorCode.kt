package com.example.weshowbackend.global.error.custom

import org.springframework.http.HttpStatus

enum class ErrorCode (
        private val status: HttpStatus,
        private val message: String
) : ErrorProperty {
    BAD_PASSWORD_EXCEPTION(HttpStatus.BAD_REQUEST, "비밀번호 틀림"),
    SAVE_IMAGE_FAILED_EXCEPTION(HttpStatus.BAD_REQUEST, "이미지 저장 실패"),

    IMAGE_NOT_VALUE_EXCEPTION(HttpStatus.NOT_FOUND, "이미지를 찾지 못함"),
    USER_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "유저를 찾지 못함"),
    PRODUCT_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "제품을 찾지 못함"),
    REVIEW_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "리뷰를 찾지 못함"),
    POINT_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "평점를 찾지 못함"),
    REFRESH_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "토큰을 찾지 못함"),

    REVIEW_CONFLICT_EXCEPTION(HttpStatus.CONFLICT, "리뷰가 이미 존재함"),
    POINT_CONFLICT_EXCEPTION(HttpStatus.CONFLICT, "평점이 이미 존재함"),

    INVALID_JWT_EXCEPTION(HttpStatus.UNAUTHORIZED, "invalid jwt"),
    EXPIRED_JWT_EXCEPTION(HttpStatus.UNAUTHORIZED, "Expired jwt"),

    USER_EXIST(HttpStatus.CONFLICT, "User Exists"),

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "server error");

    override fun status() = status.value()
    override fun message() = message
}