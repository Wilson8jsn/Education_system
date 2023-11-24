package com.example.Education_system.service


import com.example.Education_system.model.Students
import com.example.Education_system.repository.StudentsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class StudentsService {
    @Autowired
    lateinit var studentsRepository: StudentsRepository

    fun list(): List<Students> {
        return studentsRepository.findAll()
    }

    fun save(students: Students): Students {
        try {
            students.firstname?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Nombres no debe ser vacio")
            return studentsRepository.save(students)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST)
        }
    }

    fun update(students: Students): Students {
        try {
            studentsRepository.findById(students.id)
                ?: throw Exception("ID no existe")

            return studentsRepository.save(students)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(students: Students): Students {
        try {
            val response = studentsRepository.findById(students.id)
                ?: throw Exception("ID no existe")
            response.apply {
                lastname = students.lastname
            }
            return studentsRepository.save(response)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun delete(id: Long?): Boolean? {
        try {
            val response = studentsRepository.findById(id)
                ?: throw Exception("ID no existe")
            studentsRepository.deleteById(id!!)
            return true
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun listById(id: Long?): Students? {
        return studentsRepository.findById(id)
    }



}