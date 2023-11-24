package com.example.Education_system.repository

import com.example.Education_system.model.Students
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentsRepository:JpaRepository<Students, Long?> {

    fun findById (id: Long?):Students?

}

