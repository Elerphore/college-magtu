package parser.utils

import org.apache.poi.ss.usermodel.BorderStyle
import org.apache.poi.ss.usermodel.CellStyle
import org.apache.poi.ss.usermodel.HorizontalAlignment
import org.apache.poi.ss.usermodel.IndexedColors
import org.apache.poi.xssf.usermodel.XSSFCellStyle
import org.apache.poi.xssf.usermodel.XSSFWorkbook

class CellStyler(fact: XSSFWorkbook) {
    val cellStyle: XSSFCellStyle = fact.createCellStyle().apply {
        this.styleXf.applyBorder = true
        this.bottomBorderColor = IndexedColors.BLACK.index
        this.borderBottom = BorderStyle.THIN
        this.topBorderColor = IndexedColors.BLACK.index
        this.borderTop = BorderStyle.THIN
        this.leftBorderColor = IndexedColors.BLACK.index
        this.borderLeft = BorderStyle.THIN
        this.rightBorderColor = IndexedColors.BLACK.index
        this.borderRight = BorderStyle.THIN

        this.alignment = HorizontalAlignment.CENTER

    }
}
