package parser

import org.apache.poi.ss.usermodel.Sheet

interface Parsing {
    fun parse(sheet: Sheet)
}
