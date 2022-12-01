package data

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonFormat

data class Report(
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "DD.MM.YYYY")
    val date: String,
    @JsonAlias("course_name")
    val courseName: String,
    @JsonAlias("course_description")
    val courseDescription: String,
    @JsonAlias("global_group")
    val globalGroup: List<GlobalGroup>
)

