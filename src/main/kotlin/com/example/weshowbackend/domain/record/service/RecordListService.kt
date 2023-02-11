package com.example.weshowbackend.domain.record.service

import com.example.weshowbackend.domain.record.domain.repository.RecordRepository
import com.example.weshowbackend.domain.record.present.dto.RecordResponse
import com.example.weshowbackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors

@Service
class RecordListService (
        private val recordRepository: RecordRepository,
        private val userFacade: UserFacade
) {

    @Transactional(readOnly = true)
    fun execute(): RecordResponse {
        val list = recordRepository.findRecordsByUser(userFacade.getCurrentUser()).stream()
                .map {
                    it.content
                }.collect(Collectors.toList())

        return RecordResponse(
                records = list
        )
    }
}