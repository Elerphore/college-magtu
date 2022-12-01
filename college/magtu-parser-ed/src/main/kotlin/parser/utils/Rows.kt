package parser.utils

import data.Report

class Rows(private val report: Report) {
//    fun getRowConstants(index: Int, deparmentIndex: Int, groupIndex: Int): Any? =
//        when(index) {
//            0 -> { report.courseItem!!.number }
//            1 -> { report.courseItem!!.deps[deparmentIndex].code }
//            2 -> { report.courseItem!!.deps[deparmentIndex].groups[groupIndex].comeSectionItem!!.newStudents }
//            3 -> { report.courseItem!!.deps[deparmentIndex].groups[groupIndex].comeSectionItem!!.recovered }
//            4 -> { report.courseItem!!.deps[deparmentIndex].groups[groupIndex].comeSectionItem!!.newStudentsFromDifferentAcademies }
//            5 -> { report.courseItem!!.deps[deparmentIndex].groups[groupIndex].comeSectionItem!!.newStudentsFromDifferentSpecialities }
//            6 -> { report.courseItem!!.deps[deparmentIndex].groups[groupIndex].excludeSectionItem!!.failedFinalExam }
//            7 -> { report.courseItem!!.deps[deparmentIndex].groups[groupIndex].excludeSectionItem!!.finishedStudy }
//            8 -> { report.courseItem!!.deps[deparmentIndex].groups[groupIndex].excludeSectionItem!!.goneStudentsToDifferentAcademies }
//            9 -> { report.courseItem!!.deps[deparmentIndex].groups[groupIndex].excludeSectionItem!!.goneStudentsToDifferentSpecialities }
//            10 -> { report.courseItem!!.deps[deparmentIndex].groups[groupIndex].excludeSectionItem!!.interruptingDocumentConditions }
//            11 -> { report.courseItem!!.deps[deparmentIndex].groups[groupIndex].holidaySectionItem!!.academyHoliday }
//            12 -> { report.courseItem!!.deps[deparmentIndex].groups[groupIndex].holidaySectionItem!!.childrenHoliday }
//            13 -> { report.courseItem!!.deps[deparmentIndex].groups[groupIndex].holidaySectionItem!!.armyCalled }
//            14 -> { report.courseItem!!.deps[deparmentIndex].groups[groupIndex].holidaySectionItem!!.mans }
//            15 -> { report.courseItem!!.deps[deparmentIndex].groups[groupIndex].holidaySectionItem!!.countOfChildren }
//            16 -> { report.courseItem!!.deps[deparmentIndex].groups[groupIndex].countItem }
//            else -> { "nothing" }
//        }

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
