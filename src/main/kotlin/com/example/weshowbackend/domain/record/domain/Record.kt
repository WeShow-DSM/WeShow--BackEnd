package com.example.weshowbackend.domain.record.domain

import com.example.weshowbackend.domain.user.domain.User
import com.example.weshowbackend.global.entity.BaseEntity
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_record")
class Record (
        @field:NotNull
        var content: String,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", nullable = false)
        val user: User
) :BaseEntity() {
}