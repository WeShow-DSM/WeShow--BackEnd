package com.example.weshowbackend.domain.product.domain

import com.example.weshowbackend.domain.point.domain.Point
import com.example.weshowbackend.domain.product.domain.type.Category
import com.example.weshowbackend.domain.user.domain.User
import com.example.weshowbackend.global.entity.BaseEntity
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_product")
class Product (
        @field:NotNull
        var title: String,

        @field:NotNull
        var price: Int,

        @field:NotNull
        var comment: String,

        @field:NotNull
        var average: Float,

        @field:NotNull
        @field:Enumerated(EnumType.STRING)
        var category: Category,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", nullable = false)
        val user: User,

        @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
        val point: List<Point> = emptyList()
) : BaseEntity() {
        fun add(point: Point) {
                this.point.plus(point)
        }

        fun edit(average: Float) {
                this.average = average
        }
}