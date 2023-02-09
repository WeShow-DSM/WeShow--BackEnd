package com.example.weshowbackend.s3

import org.springframework.web.multipart.MultipartFile

interface ImageService {
    fun upload(file: MultipartFile): String
}