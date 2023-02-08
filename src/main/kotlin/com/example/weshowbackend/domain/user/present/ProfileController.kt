package com.example.weshowbackend.domain.user.present

import com.example.weshowbackend.domain.user.present.dto.EditNameRequest
import com.example.weshowbackend.domain.user.present.dto.ProfileResponse
import com.example.weshowbackend.domain.user.service.EditNameService
import com.example.weshowbackend.domain.user.service.ProfileService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/profile")
class ProfileController (
        private val profileService: ProfileService,
        private val editNameService: EditNameService
) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun profile(): ProfileResponse {
        return profileService.profile()
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun editName(@RequestBody request: EditNameRequest) {
        editNameService.edit(request)
    }
}