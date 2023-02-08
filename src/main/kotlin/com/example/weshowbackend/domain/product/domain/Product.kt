package com.example.weshowbackend.domain.product.domain

import com.example.weshowbackend.domain.product.domain.type.Category
import com.example.weshowbackend.global.entity.BaseEntity
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Table
import javax.validation.constraints.NotNull

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