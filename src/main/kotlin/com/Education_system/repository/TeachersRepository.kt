package com.example.Education_system.repository


import com.example.Education_system.model.Teachers
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TeachersRepository:JpaRepository<Teachers, Long?> {

    fun findById (id: Long?):Teachers?

}

