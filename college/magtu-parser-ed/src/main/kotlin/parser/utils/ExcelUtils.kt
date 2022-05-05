package parser.utils

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import parser.Report
import java.util.Date

class ExcelUtils {
    fun renderNumericData(fact: XSSFWorkbook, report: Report) =
        Rows(report).let { rows -> for(index in 0..16) renderRow(fact, rows.getRowConstants(index), index) }

    private fun renderRow(fact: XSSFWorkbook, rowConstant: Any?, index: Int) =
        fact.apply {
            this.getSheetAt(0)
                .createRow(index)
                .getCell(0)
                .apply {
                    when(rowConstant) {
                        (rowConstant is String) -> { this.setCellValue(rowConstant as? String) }
                        (rowConstant is Int?) -> { this.setCellValue(rowConstant) }
                        (rowConstant is Date?) -> { this.setCellValue(rowConstant) }
                        (rowConstant is Boolean?) -> { this.setCellValue(rowConstant) }
                    }
                }
        }



}
