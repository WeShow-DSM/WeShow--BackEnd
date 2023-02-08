package com.example.weshowbackend.domain.user.present.dto

data class SignInRequest (
        val accountId: String,
        val password: String
)
