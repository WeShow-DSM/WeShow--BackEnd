package com.example.weshowbackend.domain.auth.domain

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import org.springframework.data.redis.core.index.Indexed
import javax.validation.constraints.NotBlank

@RedisHash
class RefreshToken(
        @Id
        val id: String,

        @Indexed
        @NotBlank
        var token: String,

        @TimeToLive
        var timeToLive: Long
) {
        fun edit(token: String) {
                this.token = token
        }
}