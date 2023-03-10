package com.example.weshowbackend.domain.v1.present

import com.example.weshowbackend.domain.v1.present.dto.GetOneResponse
import com.example.weshowbackend.domain.v1.present.dto.MyPageResponse
import com.example.weshowbackend.domain.v1.present.dto.ProductRequest
import com.example.weshowbackend.domain.v1.service.*
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/product")
class V1Controller (
        private val myProductService: MyProductService,
        private val postProductService: PostProductService,
        private val editProductService: EditProductService,
        private val getProductService: GetProductService,
        private val deleteProductService: DeleteProductService
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

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/v1/{id}")
    fun patch(@PathVariable("id") id: Long, @RequestBody request: ProductRequest) {
        editProductService.execute(id, request)
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/v1/{id}")
    fun get(@PathVariable("id") id: Long):GetOneResponse {
        return getProductService.execute(id)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/v1/{id}")
    fun delete(@PathVariable("id") id: Long) {
        deleteProductService.execute(id)
    }
}