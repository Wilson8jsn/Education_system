package com.example.Education_system.controller



import com.example.Education_system.model.Teachers
import com.example.Education_system.service.TeachersService
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
@RequestMapping("/teachers")
class TeachersController {
    @Autowired
    lateinit var teachersService: TeachersService

    @GetMapping
    fun list ():List <Teachers>{
        return teachersService.list()
    }

    @PostMapping
    fun save (@RequestBody @Valid teachers: Teachers): ResponseEntity<Teachers> {
        return ResponseEntity(teachersService.save(teachers), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody teachers: Teachers): ResponseEntity<Teachers> {
        return ResponseEntity(teachersService.update(teachers), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody teachers: Teachers): ResponseEntity<Teachers> {
        return ResponseEntity(teachersService.updateName(teachers), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return teachersService.delete(id)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<Teachers>{
        return ResponseEntity(teachersService.listById (id), HttpStatus.OK)

    }
}