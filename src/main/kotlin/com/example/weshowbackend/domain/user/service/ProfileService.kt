package com.example.weshowbackend.domain.user.service

import com.example.weshowbackend.domain.user.facade.UserFacade
import com.example.weshowbackend.domain.user.present.dto.ProfileResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProfileService (
        private val userFacade: UserFacade
) {

    @Transactional(readOnly = true)
    fun profile(): ProfileResponse {
        return ProfileResponse(
                nick = userFacade.getCurrentUser().nickname
        )
    }
}