package com.example.weshowbackend.domain.user.present.dto

data class SignUpRequest (
        val accountId : String,
        val password: String,
        val nickname: String
)