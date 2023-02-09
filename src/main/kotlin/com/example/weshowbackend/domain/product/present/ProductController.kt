package com.example.weshowbackend.domain.product.present

import com.example.weshowbackend.domain.product.present.dto.CategorySearchResponse
import com.example.weshowbackend.domain.product.present.dto.MainListResponse
import com.example.weshowbackend.domain.product.present.dto.ProductElementResponse
import com.example.weshowbackend.domain.product.service.CategorySearchService
import com.example.weshowbackend.domain.product.service.MainListService
import com.example.weshowbackend.domain.product.service.ProductDetailsService
import com.example.weshowbackend.domain.product.service.TitleSearchService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/product")
class ProductController (
        private val productDetailsService: ProductDetailsService,
        private val mainListService: MainListService,
        private val categorySearchService: CategorySearchService,
        private val titleSearchService: TitleSearchService
) {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    fun detail(@PathVariable("id") id: Long): ProductElementResponse {
        return productDetailsService.execute(id)
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    fun list(): MainListResponse {
        return mainListService.mainList()
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/category/{category}")
    fun category(@PathVariable("category") category: String): CategorySearchResponse {
        return categorySearchService.execute(category)
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/search/{title}")
    fun search(@PathVariable("title") title: String): CategorySearchResponse {
        return titleSearchService.execute(title)
    }
}