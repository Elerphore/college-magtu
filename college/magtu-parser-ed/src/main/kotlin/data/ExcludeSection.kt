package data

data class ExcludeSection(
    val goneStudentsToDifferentAcademies: Int? = null,
    val goneStudentsToDifferentSpecialities: Int? = null,
    val interruptingDocumentConditions: Int? = null,
    val failedFinalExam: Int? = null,
    val finishedStudy: Int? = null
)