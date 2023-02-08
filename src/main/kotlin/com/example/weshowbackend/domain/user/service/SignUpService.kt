package com.example.weshowbackend.domain.user.service

import com.example.weshowbackend.domain.user.domain.User
import com.example.weshowbackend.domain.user.domain.repository.UserRepository
import com.example.weshowbackend.domain.user.exception.UserExistException
import com.example.weshowbackend.domain.user.present.dto.SignUpRequest
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SignUpService (
        private val userRepository: UserRepository,
        private val passwordEncoder: PasswordEncoder
) {

    @Transactional
    fun signup(request: SignUpRequest) {

        val user = User(
                accountId = request.accountId,
                password = passwordEncoder.encode(request.password),
                nickname = request.nickname
        )

        userRepository.findUserByAccountId(request.accountId).let {
            if (it != null) {
                throw UserExistException.EXCEPTION
            }
            else {
                userRepository.save(user)
            }
        }

    }
}