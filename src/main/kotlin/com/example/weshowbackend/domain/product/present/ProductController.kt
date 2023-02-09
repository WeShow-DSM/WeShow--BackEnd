package com.example.weshowbackend.domain.product.present

import com.example.weshowbackend.domain.product.present.dto.ProductElementResponse
import com.example.weshowbackend.domain.product.service.ProductDetailsService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/product")
class ProductController (
        private val productDetailsService: ProductDetailsService
) {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    fun detail(@PathVariable("id") id: Long): ProductElementResponse {
        return productDetailsService.execute(id)
    }


}