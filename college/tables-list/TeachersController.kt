package ru.magtu.manager.API

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.magtu.manager.data.Student
import ru.magtu.manager.data.Teacher
import ru.magtu.manager.data.TeachersRepository

@RestController
@RequestMapping("/teachers")
class TeachersController(
    val teachersRepository: TeachersRepository
) {

    @GetMapping
    fun teachers()  = teachersRepository.findAll()

    @PostMapping
    fun add(@RequestBody teacher: Teacher) = teachersRepository.save(teacher)

    @GetMapping("/{id}")
    fun teacherById(id: String) = teachersRepository.findById(id)

    @GetMapping("/{group}")
    fun teachersByGroup(group: String) = teachersRepository.findAllByGroup(group)

    @GetMapping("/{surname}")
    fun teachersBySurname(surname: String) = teachersRepository.findAllByGroup(surname)
}