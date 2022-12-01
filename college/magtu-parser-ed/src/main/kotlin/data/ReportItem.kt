package data

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonFormat

data class ReportItem(
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "DD.MM.YYYY")
    val date: String,
    val name: String,
    @JsonAlias("course")
    val courseItem : CourseItem? = CourseItem()
)

