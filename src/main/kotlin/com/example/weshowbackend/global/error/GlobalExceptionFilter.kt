package com.example.weshowbackend.global.error

import com.example.weshowbackend.global.error.custom.CustomException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(CustomException::class)
    fun of(e: CustomException): ResponseEntity<ErrorResponse<Unit>> {
        return ResponseEntity(ErrorResponse.of(e), HttpStatus.valueOf(e.status))
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun valid(e: MethodArgumentNotValidException): ResponseEntity<ErrorResponse<Unit>> {
        return ResponseEntity(ErrorResponse.valid(400, "잘못된 요청"), HttpStatus.valueOf(400))
    }
}