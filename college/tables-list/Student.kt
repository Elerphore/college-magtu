package ru.magtu.manager.data

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document
class Student(
    @Id
    var id: String? = null,

    @Field
    val name: String,

    @Field
    val surname: String,

    @Field
    val group: String,

    @Field
    val course: String,

    @Field
    val department: String,
)
