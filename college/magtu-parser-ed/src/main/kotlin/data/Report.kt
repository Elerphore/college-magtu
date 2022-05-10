package data

import com.fasterxml.jackson.annotation.JsonFormat

data class Report(
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "DD.MM.YYYY")
    val date: String,
    val name: String,
    val course : Course? = Course()
)

data class Count(val free: Int? = null, val paid: Int? = null)

data class HolidaySection(
    val countOfChildren: Int? = null,
    val mans: Int? = null,
    val academyHoliday: Int? = null,
    val childrenHoliday: Int? = null,
    val armyCalled: Int? = null
)

data class ComeSection(
    val newStudents: Int? = null,
    val newStudentsFromDifferentAcademies: Int? = null,
    val newStudentsFromDifferentSpecialities: Int? = null,
    val recovered: Int? = null
)

data class ExcludeSection(
    val goneStudentsToDifferentAcademies: Int? = null,
    val goneStudentsToDifferentSpecialities: Int? = null,
    val interruptingDocumentConditions: Int? = null,
    val failedFinalExam: Int? = null,
    val finishedStudy: Int? = null
)

data class Groups(
    val name: String? = null,
    val count: Count? = Count(),
    val holidaySection: HolidaySection? = HolidaySection(),
    val comeSection: ComeSection? = ComeSection(),
    val excludeSection: ExcludeSection? = ExcludeSection()
)

data class Deps(val code   : String? = null, val groups : ArrayList<Groups> = arrayListOf())
data class Course(val number : Int? = null, val deps   : ArrayList<Deps> = arrayListOf())
