package com.example.weshowbackend.domain.record.domain.repository

import com.example.weshowbackend.domain.record.domain.Record
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RecordRepository : CrudRepository<Record, Long> {
}