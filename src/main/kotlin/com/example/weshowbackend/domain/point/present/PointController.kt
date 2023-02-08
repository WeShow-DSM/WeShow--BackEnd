package com.example.weshowbackend.domain.point.present

import com.example.weshowbackend.domain.point.present.dto.PointRequest
import com.example.weshowbackend.domain.point.service.DeletePointService
import com.example.weshowbackend.domain.point.service.EditPointService
import com.example.weshowbackend.domain.point.service.SavePointService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/point")
class PointController (
        private val savePointService: SavePointService,
        private val editPointService: EditPointService,
        private val deletePointService: DeletePointService
) {

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    fun savePoint(@PathVariable("id") id: Long, @RequestBody request: PointRequest) {
        savePointService.save(id, request)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun editPoint(@PathVariable("id") id: Long, @RequestBody request: PointRequest) {
        editPointService.edit(id, request)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletePoint(@PathVariable("id") id: Long) {
        deletePointService.delete(id)
    }
}