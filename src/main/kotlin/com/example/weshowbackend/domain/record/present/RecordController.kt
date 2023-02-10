package com.example.weshowbackend.domain.record.present

import com.example.weshowbackend.domain.record.present.dto.RecordResponse
import com.example.weshowbackend.domain.record.service.RecordListService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/record")
class RecordController (
        private val recordListService: RecordListService
) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun record():RecordResponse {
        return recordListService.execute()
    }
}