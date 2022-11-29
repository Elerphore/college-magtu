package data

import com.fasterxml.jackson.annotation.JsonFormat

data class ReportItem(
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "DD.MM.YYYY")
    val date: String,
    val name: String,
    val courseItem : CourseItem? = CourseItem()
)

