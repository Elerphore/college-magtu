package parser.utils

import data.ReportItem

class Rows(private val reportItem: ReportItem) {
    fun getRowConstants(index: Int, deparmentIndex: Int, groupIndex: Int): Any? =
        when(index) {
            0 -> { reportItem.courseItem!!.number }
            1 -> { reportItem.courseItem!!.deps[deparmentIndex].code }
            2 -> { reportItem.courseItem!!.deps[deparmentIndex].groups[groupIndex].comeSectionItem!!.newStudents }
            3 -> { reportItem.courseItem!!.deps[deparmentIndex].groups[groupIndex].comeSectionItem!!.recovered }
            4 -> { reportItem.courseItem!!.deps[deparmentIndex].groups[groupIndex].comeSectionItem!!.newStudentsFromDifferentAcademies }
            5 -> { reportItem.courseItem!!.deps[deparmentIndex].groups[groupIndex].comeSectionItem!!.newStudentsFromDifferentSpecialities }
            6 -> { reportItem.courseItem!!.deps[deparmentIndex].groups[groupIndex].excludeSectionItem!!.failedFinalExam }
            7 -> { reportItem.courseItem!!.deps[deparmentIndex].groups[groupIndex].excludeSectionItem!!.finishedStudy }
            8 -> { reportItem.courseItem!!.deps[deparmentIndex].groups[groupIndex].excludeSectionItem!!.goneStudentsToDifferentAcademies }
            9 -> { reportItem.courseItem!!.deps[deparmentIndex].groups[groupIndex].excludeSectionItem!!.goneStudentsToDifferentSpecialities }
            10 -> { reportItem.courseItem!!.deps[deparmentIndex].groups[groupIndex].excludeSectionItem!!.interruptingDocumentConditions }
            11 -> { reportItem.courseItem!!.deps[deparmentIndex].groups[groupIndex].holidaySectionItem!!.academyHoliday }
            12 -> { reportItem.courseItem!!.deps[deparmentIndex].groups[groupIndex].holidaySectionItem!!.childrenHoliday }
            13 -> { reportItem.courseItem!!.deps[deparmentIndex].groups[groupIndex].holidaySectionItem!!.armyCalled }
            14 -> { reportItem.courseItem!!.deps[deparmentIndex].groups[groupIndex].holidaySectionItem!!.mans }
            15 -> { reportItem.courseItem!!.deps[deparmentIndex].groups[groupIndex].holidaySectionItem!!.countOfChildren }
            16 -> { reportItem.courseItem!!.deps[deparmentIndex].groups[groupIndex].countItem }
            else -> { "nothing" }
        }

    fun getRowTitles(index: Int): Any =
        when(index) {
            0 -> { "number" }
            1 -> { "code" }
            2 -> { "newStudents" }
            3 -> { "recovered" }
            4 -> { "newStudentsFromDifferentAcademies" }
            5 -> { "newStudentsFromDifferentSpecialities" }
            6 -> { "failedFinalExam" }
            7 -> { "finishedStudy" }
            8 -> { "goneStudentsToDifferentAcademies" }
            9 -> { "goneStudentsToDifferentSpecialities" }
            10 -> { "interruptingDocumentConditions" }
            11 -> { "academyHoliday" }
            12 -> { "childrenHoliday" }
            13 -> { "armyCalled" }
            14 -> { "mans" }
            15 -> { "countOfChildren" }
            16 -> { "count" }
            else -> { "nothing" }
        }
}
