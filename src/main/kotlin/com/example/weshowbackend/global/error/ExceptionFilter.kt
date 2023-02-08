package com.example.weshowbackend.global.error

import com.example.weshowbackend.global.error.custom.CustomException
import com.example.weshowbackend.global.error.exception.InternalServerException
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter

class ExceptionFilter (
        private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: Exception) {
            when(e) {
                is CustomException -> handlerException(e, response)
                else -> handlerException(InternalServerException, response)
            }
        }
    }

    private fun handlerException(e: CustomException ,response: HttpServletResponse) {
        val error = ErrorResponse.of(e)

        response.status = error.status
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.writer.write(objectMapper.writeValueAsString(error))
    }
}