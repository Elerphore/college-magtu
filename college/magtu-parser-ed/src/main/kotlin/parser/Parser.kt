package parser

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.*
import data.Report
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import parser.utils.CellStyler
import parser.utils.ExcelUtils
import java.io.File
import java.io.FileOutputStream

class Parser {
    val mapper = jacksonObjectMapper().apply { this.registerKotlinModule(); this.registerModule(JavaTimeModule()); }
    val fact = XSSFWorkbook()
    val sheet = fact.createSheet()
    val parsedFile = File("${System.getProperty("user.dir")}/ready_table.xlsx")
    val excelUtils: ExcelUtils = ExcelUtils(CellStyler(fact))

    fun renderExcelFile(dataFile: File) {
        dataFile.readText().let {
            val report = mapper.readValue<Report>(it)

            generateTable(sheet, report)
            val ops = FileOutputStream(parsedFile)
            fact.write(ops)
        }
    }

    private fun generateTable(sheet: XSSFSheet, report: Report) : XSSFSheet {
        return excelUtils.renderNumericData(sheet, report)
    }
}
