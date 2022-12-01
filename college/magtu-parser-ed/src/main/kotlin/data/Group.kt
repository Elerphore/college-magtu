package data

import com.fasterxml.jackson.annotation.JsonAlias

data class Group(
    @JsonAlias("name")
    val name: String,
    @JsonAlias("underageStudents")
    val underageStudents: CategoryInformation,
    @JsonAlias("man")
    val man: CategoryInformation,
    @JsonAlias("academic")
    val academic: CategoryInformation,
    @JsonAlias("childHolidays")
    val childHolidays: CategoryInformation,
    @JsonAlias("callOfArmy")
    val callOfArmy: CategoryInformation,
    @JsonAlias("studyingIncome")
    val studyingIncome: CategoryInformation,
    @JsonAlias("studyingIncomeFromOtherInstitution")
    val studyingIncomeFromOtherInstitution: CategoryInformation,
    @JsonAlias("studyingIncomeFromOtherSpecialities")
    val studyingIncomeFromOtherSpecialities: CategoryInformation,
    @JsonAlias("restored")
    val restored: CategoryInformation,
    @JsonAlias("movedToAnotherInstitution")
    val movedToAnotherInstitution: CategoryInformation,
    @JsonAlias("movedToAnotherSpeciality")
    val movedToAnotherSpeciality: CategoryInformation,
    @JsonAlias("contractBreach")
    val contractBreach: CategoryInformation,
    @JsonAlias("academicDebt")
    val academicDebt: CategoryInformation,
    @JsonAlias("notCertified")
    val notCertified: CategoryInformation,
    @JsonAlias("finished")
    val finished: CategoryInformation,
    @JsonAlias("other")
    val other: CategoryInformation,
)