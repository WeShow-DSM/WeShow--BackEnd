package com.example.weshowbackend.domain.image.domain

import com.example.weshowbackend.domain.product.domain.Product
import com.example.weshowbackend.global.entity.BaseEntity
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_image")
class Image (

        @field:NotNull
        var url : String,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "product_id", nullable = false)
        val product: Product

) : BaseEntity()