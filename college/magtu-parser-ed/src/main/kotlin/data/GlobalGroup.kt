package data

import com.fasterxml.jackson.annotation.JsonAlias

data class GlobalGroup(
    @JsonAlias("code")
    val code: String,
    @JsonAlias("groups")
    val groups: List<Group>
)