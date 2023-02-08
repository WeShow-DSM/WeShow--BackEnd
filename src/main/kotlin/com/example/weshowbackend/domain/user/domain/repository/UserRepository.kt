package com.example.weshowbackend.domain.user.domain.repository

import com.example.weshowbackend.domain.user.domain.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, Long> {
}