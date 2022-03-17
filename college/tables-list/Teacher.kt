package ru.magtu.manager.data

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document
class Teacher(
    @Id
    var id: String? = null,

    @Field
    val name: String,

    @Field
    val surname: String,

    @Field
    val group: String,

    @Field
    val patronymic: String,

    @Field
    val subject: String,
)
