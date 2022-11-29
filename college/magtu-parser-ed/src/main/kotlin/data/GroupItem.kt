package data

data class GroupItem(
    val name: String? = null,
    val countItem: CountItem? = CountItem(),
    val holidaySectionItem: HolidaySectionItem? = HolidaySectionItem(),
    val comeSectionItem: ComeSectionItem? = ComeSectionItem(),
    val excludeSectionItem: ExcludeSectionItem? = ExcludeSectionItem()
)