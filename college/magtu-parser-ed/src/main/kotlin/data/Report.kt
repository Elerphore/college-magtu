package data

import com.fasterxml.jackson.annotation.JsonFormat

data class Report(
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "DD.MM.YYYY")
    val date: String,
    val name: String,
    val course : Course? = Course()
)

