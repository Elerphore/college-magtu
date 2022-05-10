package data

data class Groups(
    val name: String? = null,
    val count: Count? = Count(),
    val holidaySection: HolidaySection? = HolidaySection(),
    val comeSection: ComeSection? = ComeSection(),
    val excludeSection: ExcludeSection? = ExcludeSection()
)