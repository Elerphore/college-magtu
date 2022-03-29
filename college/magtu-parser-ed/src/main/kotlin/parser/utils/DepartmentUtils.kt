package parser.utils

import org.apache.poi.ss.usermodel.Sheet
import parser.Parsing

class DepartmentUtils : Parsing {
    override fun parse(sheet: Sheet) {
        println(sheet.sheetName)

        var currentRow = 0;

        while(sheet.getRow(currentRow)?.getCell(2)?.dateCellValue != null) {

            sheet.getRow(currentRow)
                .forEach { cell ->
                    if(cell.dateCellValue != null) println("row: ${cell.address.row} column: ${cell.address.column} value: ${cell.dateCellValue.}")
                }

            currentRow += 40
        }

    }
}
