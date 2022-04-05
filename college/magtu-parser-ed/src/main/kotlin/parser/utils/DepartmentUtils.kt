package parser.utils

import org.apache.poi.ss.usermodel.Sheet
import parser.Coordinate
import parser.Parsing

class DepartmentUtils : Parsing {
    override fun parse(sheet: Sheet) {
        println(sheet.sheetName)

        var startRow = 0;

        val courseConst = Coordinate(2, 3)
        val depConst = Coordinate(3, 3)
        val groupConst = Coordinate(4, 3)

        while(sheet.getRow(startRow)?.getCell(2)?.dateCellValue != null) {

            sheet.getRow(startRow).forEach { cell -> if(cell.dateCellValue != null) println("row: ${cell.address.row} column: ${cell.address.column} value: ${cell.dateCellValue}") }
            sheet.getRow(startRow + courseConst.y).getCell(courseConst.x).run { println("course: ${this.stringCellValue}") }
            sheet.getRow(startRow + depConst.y).forEach { cell ->
                if(cell.stringCellValue.isNotBlank()) {
                    println("dep: ${cell.stringCellValue}")
                }
            }

            sheet.getRow(startRow + groupConst.y).forEach { cell ->
                if(cell.stringCellValue.isNotBlank()) {
                    println("group: ${cell.stringCellValue}")
                }
            }

            sheet.getRow(startRow + groupConst.y).forEach { cell ->
                if(cell.stringCellValue.isNotBlank()) {
                    println("group: ${cell.stringCellValue}")
                }
            }

            startRow += 40
        }

    }
}
