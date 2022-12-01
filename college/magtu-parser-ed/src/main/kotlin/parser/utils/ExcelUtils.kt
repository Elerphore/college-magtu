package parser.utils

import data.Report
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File
import java.io.FileOutputStream
import java.util.*

object ExcelUtils {
    private val fact = XSSFWorkbook()
    private val sheet: XSSFSheet = fact.createSheet()
    private val styles = CellStyler(fact)
    private val parsedFile = File("${System.getProperty("user.dir")}/ready_table.xlsx")

    fun renderTableTitle(report: Report) {

    }

    fun renderNumericData(report: Report): XSSFSheet {
//        for(indexDepartment in report.courseItem!!.deps.indices) {
//            for(indexGroup in report.courseItem.deps[indexDepartment].groups.indices) {
//                Rows(report).let { rows ->
//                    for(index in 0..16) {
//                        renderRow(
//                            rows.getRowTitles(index),
//                            indexDepartment,
//                            indexGroup,
//                            index,
//                            true,
//                        )
//
//                        renderRow(
//                            rowConstant = rows.getRowConstants(index, indexDepartment, indexGroup),
//                            indexDepartment = indexDepartment,
//                            indexGroup = indexGroup,
//                            index = index,
//                            isTitle = false,
//                        )
//                    }
//                }
//            }
//        }
        return sheet
    }

    private fun renderRow(
        rowConstant: Any?,
        indexDepartment: Int,
        indexGroup: Int,
        index: Int,
        isTitle: Boolean = false,
    ): XSSFSheet =
        sheet.apply {
            (getRow((indexDepartment * 18) + (index)) ?: createRow((indexDepartment * 18) + (index)))
                .createCell((1 + indexGroup) * 3 - if(isTitle) 3 else 2)?.apply {
                    this.cellStyle = styles.cellStyle
                    when(rowConstant) {
                        is String -> { setCellValue(rowConstant) }
                        is Int -> { setCellValue(rowConstant.toDouble()) }
                        is Date -> { setCellValue(rowConstant) }
                        is Boolean -> { setCellValue(rowConstant) }
                        else -> println("not string")
                    }
                }
        }

    fun write() {
        val ops = FileOutputStream(parsedFile)
        fact.write(ops)
    }
}
