package parser

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.*
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File
import java.io.FileOutputStream

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

class Parser {
    val mapper = jacksonObjectMapper().apply { this.registerKotlinModule(); this.registerModule(JavaTimeModule()); }
    val fact = XSSFWorkbook()
    val sheet = fact.createSheet()
    val parsedFile = File("/home/elerphore/ready_table.xlsx")

    fun renderExcelFile() {
        val jsFile = File("/home/elerphore/students.json")

        jsFile.readText().let {
            val report = mapper.readValue<Report>(it)

            generateTable(sheet, report)
            val ops = FileOutputStream(parsedFile)
            fact.write(ops)
        }
    }

    private fun generateTable(sheet: XSSFSheet, report: Report) : XSSFSheet {
        val row = sheet.createRow(0)
        val column = row.createCell(0)

        column.setCellValue(report.date)
        return sheet
    }
}
