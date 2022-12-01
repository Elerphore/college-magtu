package data

import com.fasterxml.jackson.annotation.JsonAlias

data class GroupItem(
    val name: String? = null,
    @JsonAlias("count")
    val countItem: CountItem? = CountItem(),

    @JsonAlias("holidaySection")
    val holidaySectionItem: HolidaySectionItem? = HolidaySectionItem(),

    @JsonAlias("comeSection")
    val comeSectionItem: ComeSectionItem? = ComeSectionItem(),

    @JsonAlias("excludeSection")
    val excludeSectionItem: ExcludeSectionItem? = ExcludeSectionItem()
)