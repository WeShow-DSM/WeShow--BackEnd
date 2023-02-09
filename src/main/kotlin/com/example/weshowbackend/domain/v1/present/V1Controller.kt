package com.example.weshowbackend.domain.v1.present

import com.example.weshowbackend.domain.v1.present.dto.MyPageResponse
import com.example.weshowbackend.domain.v1.present.dto.ProductRequest
import com.example.weshowbackend.domain.v1.service.MyProductService
import com.example.weshowbackend.domain.v1.service.PostProductService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/product")
class V1Controller (
        private val myProductService: MyProductService,
        private val postProductService: PostProductService
) {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/v1")
    fun myPage():MyPageResponse {
        return myProductService.myPage()
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/v1")
    fun post(@RequestBody request: ProductRequest) {
        postProductService.execute(request)
    }
}