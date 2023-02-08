package com.example.weshowbackend.domain.auth.service

import com.example.weshowbackend.domain.auth.domain.repository.RefreshTokenRepository
import com.example.weshowbackend.domain.auth.exception.RefreshTokenNotFoundException
import com.example.weshowbackend.domain.user.facade.UserFacade
import com.example.weshowbackend.domain.user.present.dto.TokenResponse
import com.example.weshowbackend.global.error.exception.InvalidJwtException
import com.example.weshowbackend.global.security.jwt.JwtProperties
import com.example.weshowbackend.global.security.jwt.JwtTokenProvider
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class RefreshService(
        private val jwtTokenProvider: JwtTokenProvider,
        private val refreshTokenRepository: RefreshTokenRepository,
        private val jwtProperties: JwtProperties,
        private val userFacade: UserFacade
) {

    @Transactional
    fun execute(refreshToken: String): TokenResponse {
        val user = userFacade.getCurrentUser()

        if (jwtTokenProvider.getTokenBody(refreshToken).get("type")?.equals("refresh") == true)
            throw InvalidJwtException.EXCEPTION

        val token = refreshTokenRepository.findByToken(refreshToken) ?: throw RefreshTokenNotFoundException.EXCEPTION

        token.edit(jwtTokenProvider.getToken(token.id).refreshToken)

        return jwtTokenProvider.getToken(token.id)
    }
}