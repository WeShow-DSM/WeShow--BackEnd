package com.example.weshowbackend.domain.record.domain.repository

import com.example.weshowbackend.domain.record.domain.Record
import com.example.weshowbackend.domain.user.domain.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RecordRepository : CrudRepository<Record, Long> {
    fun findRecordsByUser(user: User): List<Record>
}