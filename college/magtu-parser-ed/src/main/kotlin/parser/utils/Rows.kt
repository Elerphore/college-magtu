package parser.utils

import parser.Report

class Rows(report: Report) {
    val report: Report = report;

    fun getRowConstants(index: Int): Any? =
        when(index) {
            0 -> { report.course!!.number }
            1 -> { report.course!!.deps[0].code }
            2 -> { report.course!!.deps[0].groups[0].comeSection!!.newStudents }
            3 -> { report.course!!.deps[0].groups[0].comeSection!!.recovered }
            4 -> { report.course!!.deps[0].groups[0].comeSection!!.newStudentsFromDifferentAcademies }
            5 -> { report.course!!.deps[0].groups[0].comeSection!!.newStudentsFromDifferentSpecialities }
            6 -> { report.course!!.deps[0].groups[0].excludeSection!!.failedFinalExam }
            7 -> { report.course!!.deps[0].groups[0].excludeSection!!.finishedStudy }
            8 -> { report.course!!.deps[0].groups[0].excludeSection!!.goneStudentsToDifferentAcademies }
            9 -> { report.course!!.deps[0].groups[0].excludeSection!!.goneStudentsToDifferentSpecialities }
            10 -> { report.course!!.deps[0].groups[0].excludeSection!!.interruptingDocumentConditions }
            11 -> { report.course!!.deps[0].groups[0].holidaySection!!.academyHoliday }
            12 -> { report.course!!.deps[0].groups[0].holidaySection!!.childrenHoliday }
            13 -> { report.course!!.deps[0].groups[0].holidaySection!!.armyCalled }
            14 -> { report.course!!.deps[0].groups[0].holidaySection!!.mans }
            15 -> { report.course!!.deps[0].groups[0].holidaySection!!.countOfChildren }
            16 -> { report.course!!.deps[0].groups[0].count }
            else -> { "nothing" }
        }
}
