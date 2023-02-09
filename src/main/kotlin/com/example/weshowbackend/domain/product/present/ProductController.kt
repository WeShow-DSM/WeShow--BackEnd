package com.example.weshowbackend.domain.product.present

import com.example.weshowbackend.domain.product.present.dto.*
import com.example.weshowbackend.domain.product.service.*
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/product")
class ProductController (
        private val productDetailsService: ProductDetailsService,
        private val mainListService: MainListService,
        private val categorySearchService: CategorySearchService,
        private val titleSearchService: TitleSearchService,
        private val putBasketService: PutBasketService,
        private val basketListService: BasketListService,
        private val orderService: OrderService
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

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{product-id}/{count}")
    fun put(@PathVariable("product-id") productId: Long, @PathVariable("count") count: Int) {
        putBasketService.execute(productId, count)
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/basket")
    fun basket():BasketResponse {
        return basketListService.execute()
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/order")
    fun order(@RequestBody request: OrderRequest) {
        orderService.execute(request)
    }
}