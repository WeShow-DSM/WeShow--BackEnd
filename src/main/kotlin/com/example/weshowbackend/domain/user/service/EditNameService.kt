package com.example.weshowbackend.domain.user.service

import com.example.weshowbackend.domain.user.facade.UserFacade
import com.example.weshowbackend.domain.user.present.dto.EditNameRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EditNameService (
        private val userFacade: UserFacade
) {

    @Transactional
    fun edit(request: EditNameRequest) {
        userFacade.getCurrentUser().edit(request.nick)
    }
}