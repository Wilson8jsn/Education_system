package com.example.Education_system.controller



import com.example.Education_system.model.Students
import com.example.Education_system.service.StudentsService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping

@RestController
@RequestMapping("/students")
class StudentsController {
    @Autowired
    lateinit var studentsService: StudentsService

    @GetMapping
    fun list ():List <Students>{
        return studentsService.list()
    }

    @PostMapping
    fun save (@RequestBody @Valid students: Students): ResponseEntity<Students> {
        return ResponseEntity(studentsService.save(students), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody students: Students): ResponseEntity<Students> {
        return ResponseEntity(studentsService.update(students), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody students: Students): ResponseEntity<Students> {
        return ResponseEntity(studentsService.updateName(students), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return studentsService.delete(id)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<Students>{
        return ResponseEntity(studentsService.listById (id), HttpStatus.OK)

    }
}