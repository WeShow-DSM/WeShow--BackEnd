package com.example.weshowbackend.domain.user.domain

import com.example.weshowbackend.global.entity.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull

@Entity
@Table(name = "tbl_user")
class User (
        accountId: String,

        password: String,

        nickname: String

) : BaseEntity() {
    @field:NotNull
    var accountId = accountId
        protected set

    @field:NotNull
    var password = password
        protected set

    @field:NotNull
    var nickname = nickname
        protected set

    fun edit(name: String) {
        this.nickname = name
    }
}