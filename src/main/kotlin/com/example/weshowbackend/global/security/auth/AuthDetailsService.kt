package com.example.weshowbackend.global.security.auth

import com.example.weshowbackend.domain.user.domain.repository.UserRepository
import com.example.weshowbackend.domain.user.exception.UserNotFoundException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class AuthDetailService(
        private val userRepository: UserRepository
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        return AuthDetails(
                userRepository.findUserByAccountId(username) ?: throw UserNotFoundException.EXCEPTION
        )
    }
}