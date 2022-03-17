package ru.magtu.manager.API

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import ru.magtu.manager.data.Student
import ru.magtu.manager.data.StudentsRepository
import javax.annotation.PostConstruct


@RestController
@RequestMapping("/students")
class StudentsController(
    val studentsRepository: StudentsRepository,
) {

    @PostMapping
    fun add(@RequestBody student: Student) = studentsRepository.save(student)

    @GetMapping
    fun students()  = studentsRepository.findAll()

    @GetMapping("/{id}")
    fun studentById(id: String) = studentsRepository.findById(id)

    @GetMapping("/{group}")
    fun studentsByGroup(group: String) = studentsRepository.findAllByGroup(group)

    @GetMapping("/{surname}")
    fun studentsBySurname(surname: String) = studentsRepository.findAllByGroup(surname)
}