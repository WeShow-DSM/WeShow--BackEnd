package com.example.weshowbackend.domain.order.domain

import com.example.weshowbackend.domain.product.domain.Product
import com.example.weshowbackend.domain.user.domain.User
import com.example.weshowbackend.global.entity.BaseEntity
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_order")
class Order (
        @field:NotNull
        val count : Int,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", nullable = false)
        val user: User,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "product_id", nullable = false)
        val product: Product

) : BaseEntity()