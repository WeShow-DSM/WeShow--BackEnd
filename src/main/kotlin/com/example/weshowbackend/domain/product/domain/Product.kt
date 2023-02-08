package com.example.weshowbackend.domain.product.domain

import com.example.weshowbackend.domain.product.domain.type.Category
import com.example.weshowbackend.global.entity.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull

@Entity
@Table(name = "tbl_product")
class Product (
        title: String,

        price: Int,

        comment: String,

        category: Category
) : BaseEntity() {
    @field:NotNull
    var title = title
        protected set

    @field:NotNull
    var price = price
        protected set

    @field:NotNull
    var comment = comment
        protected set

    @field:NotNull
    @field:Enumerated(EnumType.STRING)
    var category = category
        protected set
}