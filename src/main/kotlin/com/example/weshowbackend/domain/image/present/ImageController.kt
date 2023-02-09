package com.example.weshowbackend.domain.image.present

import com.example.weshowbackend.domain.image.present.dto.ImageResponse
import com.example.weshowbackend.domain.image.service.ImageUploadService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/image")
class ImageController (
        private val imageUploadService: ImageUploadService
) {

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    fun upload(@RequestPart files: List<MultipartFile>): ImageResponse {
        return imageUploadService.execute(files)
    }
}