package parser.utils

import data.Report

class Rows(report: Report, ) {
    val report: Report = report

    fun getRowConstants(index: Int, deparmentIndex: Int, groupIndex: Int): Any? =
        when(index) {
            0 -> { report.course!!.number }
            1 -> { report.course!!.deps[deparmentIndex].code }
            2 -> { report.course!!.deps[deparmentIndex].groups[groupIndex].comeSection!!.newStudents }
            3 -> { report.course!!.deps[deparmentIndex].groups[groupIndex].comeSection!!.recovered }
            4 -> { report.course!!.deps[deparmentIndex].groups[groupIndex].comeSection!!.newStudentsFromDifferentAcademies }
            5 -> { report.course!!.deps[deparmentIndex].groups[groupIndex].comeSection!!.newStudentsFromDifferentSpecialities }
            6 -> { report.course!!.deps[deparmentIndex].groups[groupIndex].excludeSection!!.failedFinalExam }
            7 -> { report.course!!.deps[deparmentIndex].groups[groupIndex].excludeSection!!.finishedStudy }
            8 -> { report.course!!.deps[deparmentIndex].groups[groupIndex].excludeSection!!.goneStudentsToDifferentAcademies }
            9 -> { report.course!!.deps[deparmentIndex].groups[groupIndex].excludeSection!!.goneStudentsToDifferentSpecialities }
            10 -> { report.course!!.deps[deparmentIndex].groups[groupIndex].excludeSection!!.interruptingDocumentConditions }
            11 -> { report.course!!.deps[deparmentIndex].groups[groupIndex].holidaySection!!.academyHoliday }
            12 -> { report.course!!.deps[deparmentIndex].groups[groupIndex].holidaySection!!.childrenHoliday }
            13 -> { report.course!!.deps[deparmentIndex].groups[groupIndex].holidaySection!!.armyCalled }
            14 -> { report.course!!.deps[deparmentIndex].groups[groupIndex].holidaySection!!.mans }
            15 -> { report.course!!.deps[deparmentIndex].groups[groupIndex].holidaySection!!.countOfChildren }
            16 -> { report.course!!.deps[deparmentIndex].groups[groupIndex].count }
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
