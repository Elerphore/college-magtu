package ru.magtu.manager.data

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface StudentsRepository : ReactiveMongoRepository<Student, String> {
    fun findAllByGroup(group: String) : Flux<Student>
    fun findAllBySurname(surname: String) : Flux<Student>
}