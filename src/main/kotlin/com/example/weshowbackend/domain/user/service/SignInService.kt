package com.example.weshowbackend.domain.user.service

import com.example.weshowbackend.domain.user.domain.repository.UserRepository
import com.example.weshowbackend.domain.user.exception.BadPasswordException
import com.example.weshowbackend.domain.user.exception.UserNotFoundException
import com.example.weshowbackend.domain.user.present.dto.SignInRequest
import com.example.weshowbackend.domain.user.present.dto.TokenResponse
import com.example.weshowbackend.global.security.jwt.JwtTokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SignInService (
        private val userRepository: UserRepository,
        private val passwordEncoder: PasswordEncoder,
        private val jwtTokenProvider: JwtTokenProvider
) {

    @Transactional
    fun sign(request: SignInRequest):TokenResponse {
        val user = userRepository.findUserByAccountId(request.accountId) ?: throw UserNotFoundException.EXCEPTION

        if(!passwordEncoder.matches(request.password, user.password)) {
            throw BadPasswordException.EXCEPTION
        }

        return TokenResponse(
                jwtTokenProvider.getToken(request.accountId)
        )
    }
}