package parser.utils

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import data.Report
import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFSheet
import java.util.*

class ExcelUtils {
    fun renderNumericData(fact: XSSFSheet, report: Report): XSSFSheet =
        Rows(report).let { rows -> for(index in 0..16) renderRow(fact, rows.getRowConstants(index), index) }.let { fact }

    private fun renderRow(fact: XSSFSheet, rowConstant: Any?, index: Int): XSSFSheet =
        fact.apply {
            createRow(index)
                .createCell(0)?.apply {
                    when(rowConstant) {
                        is String -> { setCellValue(rowConstant) }
                        is Int -> { setCellValue(rowConstant.toDouble()) }
                        is Date -> { setCellValue(rowConstant) }
                        is Boolean -> { setCellValue(rowConstant) }
                        else -> println("not string")
                    }
                }
        }
}
