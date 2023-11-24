package com.example.Education_system.service




import com.example.Education_system.model.Teachers
import com.example.Education_system.repository.StudentsRepository
import com.example.Education_system.repository.TeachersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class TeachersService {
    @Autowired
    lateinit var teachersRepository: TeachersRepository

    @Autowired
    lateinit var studentsRepository: StudentsRepository


    fun list(): List<Teachers> {
        return teachersRepository.findAll()
    }


    fun save(teachers: Teachers): Teachers {
        try {
            teachers.firstname?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Nombres no debe ser vacio")
            return teachersRepository.save(teachers)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST)
        }
    }

    fun update(teachers: Teachers): Teachers {
        try {
            teachersRepository.findById(teachers.id)
                ?: throw Exception("ID no existe")

            return teachersRepository.save(teachers)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(teachers: Teachers): Teachers {
        try {
            val response = teachersRepository.findById(teachers.id)
                ?: throw Exception("ID no existe")
            response.apply {
               subject = teachers.firstname
            }
            return teachersRepository.save(response)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun delete(id: Long?): Boolean? {
        try {
            val response = teachersRepository.findById(id)
                ?: throw Exception("ID no existe")
            teachersRepository.deleteById(id!!)
            return true
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun listById(id: Long?): Teachers? {
        return teachersRepository.findById(id)
    }
    
}