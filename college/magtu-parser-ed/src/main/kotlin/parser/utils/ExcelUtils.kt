package parser.utils

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import parser.Report

class ExcelUtils {
    fun renderNumericData(fact: XSSFWorkbook, report: Report) =
        Rows(report).let { rows -> for(index in 0..16) renderRow(fact, rows.getRowConstants(index), index) }

    private fun renderRow(fact: XSSFWorkbook, rowConstant: Any?, index: Int) =
        fact.apply {
            this.getSheetAt(0)
                .createRow(index)
                .getCell(0)
                .apply {
                    this.setCellValue(rowConstant)
                }
        }



}
