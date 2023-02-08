package com.example.weshowbackend.domain.review.domain

import com.example.weshowbackend.domain.product.domain.Product
import com.example.weshowbackend.domain.user.domain.User
import com.example.weshowbackend.global.entity.BaseEntity
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_review")
class Review(

        @field:NotNull
        var comment: String,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", nullable = false)
        val user: User,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "product_id", nullable = false)
        val product: Product

) : BaseEntity() {
    fun editReview(comment: String) {
        this.comment = comment
    }
}