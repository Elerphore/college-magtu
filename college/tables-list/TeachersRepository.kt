package ru.magtu.manager.data

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux

interface TeachersRepository : ReactiveMongoRepository<Teacher, String> {
    fun findAllByGroup(group: String) : Flux<Teacher>
    fun findAllBySurname(surname: String) : Flux<Teacher>
}