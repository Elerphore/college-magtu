package parser.utils

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import data.Report
import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFSheet
import java.util.*

class ExcelUtils {
    fun renderNumericData(fact: XSSFSheet, report: Report): XSSFSheet {
        for(indexDepartment in report.course!!.deps.indices) {
            for(indexGroup in report.course!!.deps[indexDepartment].groups.indices) {
                Rows(report).let { rows -> for(index in 0..16)
                    renderRow(
                        fact,
                        rows.getRowConstants(index, indexDepartment, indexGroup),
                        indexDepartment,
                        indexGroup,
                        index
                    )
                }
            }
        }

        return fact
    }

    private fun renderRow(fact: XSSFSheet, rowConstant: Any?, indexDepartment: Int, indexGroup: Int, index: Int): XSSFSheet =
        fact.apply {
            (getRow((indexDepartment * 18) + (index)) ?: createRow((indexDepartment * 18) + (index)))
                .createCell(indexGroup * 3)?.apply {
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
