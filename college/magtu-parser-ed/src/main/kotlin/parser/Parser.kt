package parser

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.*
import data.Report
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File
import java.io.FileOutputStream

class Parser {
    val mapper = jacksonObjectMapper().apply { this.registerKotlinModule(); this.registerModule(JavaTimeModule()); }
    val fact = XSSFWorkbook()
    val sheet = fact.createSheet()
    val parsedFile = File("/home/elerphore/ready_table.xlsx")

    fun renderExcelFile(dataFile: File) {
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
