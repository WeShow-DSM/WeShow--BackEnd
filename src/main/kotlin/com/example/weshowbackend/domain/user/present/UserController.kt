package com.example.weshowbackend.domain.user.present

import com.example.weshowbackend.domain.user.present.dto.SignInRequest
import com.example.weshowbackend.domain.user.present.dto.SignUpRequest
import com.example.weshowbackend.domain.user.present.dto.TokenResponse
import com.example.weshowbackend.domain.user.service.SignInService
import com.example.weshowbackend.domain.user.service.SignUpService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController (
        private val signUpService: SignUpService,
        private val signInService: SignInService
) {

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    fun signup(@RequestBody request: SignUpRequest) {
        signUpService.signup(request)
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/sign")
    fun sign(@RequestBody request: SignInRequest): TokenResponse {
        return signInService.sign(request)
    }
}