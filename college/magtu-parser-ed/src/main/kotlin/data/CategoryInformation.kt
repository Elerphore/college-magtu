package data

import com.fasterxml.jackson.annotation.JsonAlias

data class CategoryInformation(
    @JsonAlias("budget")
    val budget: Int,
    @JsonAlias("commercial")
    val commercial: Int,
)