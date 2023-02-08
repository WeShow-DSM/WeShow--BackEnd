package com.example.weshowbackend.domain.user.present

import com.example.weshowbackend.domain.auth.service.RefreshService
import com.example.weshowbackend.domain.user.present.dto.SignInRequest
import com.example.weshowbackend.domain.user.present.dto.SignUpRequest
import com.example.weshowbackend.domain.user.present.dto.TokenResponse
import com.example.weshowbackend.domain.user.service.SignInService
import com.example.weshowbackend.domain.user.service.SignUpService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequestMapping("/user")
@RestController
class UserController (
        private val signUpService: SignUpService,
        private val signInService: SignInService,
        private val refreshService: RefreshService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    fun saveUser(@RequestBody request: SignUpRequest) {
        signUpService.signup(request)
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/sign")
    fun loginUser(@RequestBody request: SignInRequest):TokenResponse {
        return signInService.sign(request)
    }

    @PutMapping
    fun tokenReissue(@RequestHeader("Refresh-Token") refreshToken: String): TokenResponse {
        return refreshService.execute(refreshToken)
    }
}