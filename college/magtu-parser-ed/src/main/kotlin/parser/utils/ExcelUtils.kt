package parser.utils

import data.CategoryInformation
import data.Group
import data.Report
import org.apache.poi.ss.usermodel.BorderStyle
import org.apache.poi.ss.usermodel.HorizontalAlignment
import org.apache.poi.ss.util.CellRangeAddress
import org.apache.poi.ss.util.RegionUtil
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File
import java.io.FileOutputStream
import kotlin.reflect.full.memberProperties

object ExcelUtils {
    private val fact = XSSFWorkbook()
    private val sheet: XSSFSheet = fact.createSheet()
    private val styles = CellStyler(fact)
    private val parsedFile = File("${System.getProperty("user.dir")}/ready_table.xlsx")
    private val lastRowTable = 0

    private fun renderTableTitle(report: Report) =
        with(sheet) {
            with(getRow(0) ?: createRow(0)) { with(createCell(2)) { setCellValue(report.date); cellStyle.alignment = HorizontalAlignment.CENTER } }
            with(getRow(1) ?: createRow(1)) { with(createCell(0)) { setCellValue(report.courseDescription); cellStyle.alignment = HorizontalAlignment.CENTER } }
        }

    private fun renderPrefixInfoColumns(report: Report) =
        with(sheet) {
            with(getRow(2) ?: createRow(2)) {
                with(createCell(0)) { setCellValue("№"); cellStyle.alignment = HorizontalAlignment.CENTER }
                with(createCell(1)) { setCellValue("Показатели"); cellStyle.alignment = HorizontalAlignment.CENTER }
                with(createCell(3)) { setCellValue(report.courseName); cellStyle.alignment = HorizontalAlignment.CENTER }
            }
            addMergedRegion(CellRangeAddress.valueOf("A3:A5"))
            addMergedRegion(CellRangeAddress.valueOf("B3:C5"))
            addMergedRegion(CellRangeAddress(2, 2, 3, (report.globalGroup.size) * 4 + 2))
        }

    private fun renderGeneralGroup(report: Report) =
        with(sheet) {
            with(createRow(3)) {
                var lastRenderedCell: Int? = null
                report.globalGroup.forEachIndexed { index, globalGroup ->
                    val cellIndex: Int = if(lastRenderedCell == null) 3 + index else lastRenderedCell!! + 1

                    lastRenderedCell = 3 + cellIndex

                    addMergedRegion(CellRangeAddress(3, 3, cellIndex, lastRenderedCell!!))
                    with(createCell(cellIndex)) { setCellValue(globalGroup.code) }
                }
            }
        }

    private fun renderGroup(report: Report) =
        with(sheet) {
            with(createRow(4)) {
                var lastRenderedCell: Int? = null
                report.globalGroup.forEachIndexed { globalGroupIndex, globalGroup ->
                    globalGroup.groups.forEachIndexed { groupIndex, group ->
                        val cellIndex: Int = if(lastRenderedCell == null) 3 + groupIndex else lastRenderedCell!! + 1

                        lastRenderedCell = 1 + cellIndex

                        addMergedRegion(CellRangeAddress(4, 4, cellIndex, lastRenderedCell!!))
                        with(createCell(cellIndex)) { setCellValue(group.name); cellStyle.alignment = HorizontalAlignment.CENTER }
                    }
                }
            }
        }

    private fun renderGroupStudentBudgetOrCommercial(report: Report) =
        with(sheet) {
            with(createRow(5)) {

                addMergedRegion(CellRangeAddress.valueOf("B6:C6"))
                with(createCell(0)) { cellStyle = styles.cellStyle }

                var lastRenderedCell: Int? = null
                report.globalGroup.forEachIndexed { globalGroupIndex, globalGroup ->
                    globalGroup.groups.forEachIndexed { groupIndex, group ->
                        val cellIndex: Int = if(lastRenderedCell == null) 3 + groupIndex else lastRenderedCell!! + 1

                        with(createCell(cellIndex)) { setCellValue("б"); cellStyle = styles.cellStyle }
                        with(createCell(cellIndex + 1)) { setCellValue("вб"); cellStyle = styles.cellStyle }

                        lastRenderedCell = 1 + cellIndex
                    }
                }

            }
        }

    private fun getPropertyRow(propertyName: String): Int? =
        when(propertyName) {
            "underageStudents" -> 7
            "man" -> 8
            "academic" -> 11
            "childHolidays" -> 12
            "callOfArmy" -> 13
            "studyingIncome" -> 16
            "studyingIncomeFromOtherInstitution" -> 17
            "studyingIncomeFromOtherSpecialities" -> 18
            "restored" -> 19
            "movedToAnotherInstitution" -> 22
            "movedToAnotherSpeciality" -> 23
            "contractBreach" -> 25
            "academicDebt" -> 26
            "notCertified" -> 27
            "finished" -> 28
            "other" -> 29
            else -> null
        }

    private fun getPropertyInformation(propertyName: String): Triple<Int, Int, String>? =
        when(propertyName) {
            "underageStudents" ->
                Triple(2, 7, "Кол-во несовершн.студент.")
            "man" ->
                Triple(3, 8, "Кол-во юношей")
            "academic" ->
                Triple(6, 11, "академический отпуск")
            "childHolidays" ->
                Triple(7, 12, "отпуск по уходу за ребенком")
            "callOfArmy" ->
                Triple(8, 13, "призваны в ряды РА")
            "studyingIncome" ->
                Triple(11, 16, "зачислено на обучение")
            "studyingIncomeFromOtherInstitution" ->
                Triple(12, 17, "прибыло из других уч. заведений")
            "studyingIncomeFromOtherSpecialities" ->
                Triple(13, 18, "переведено с др. видов обучения")
            "restored" ->
                Triple(14, 19, "восстановлено")
            "movedToAnotherInstitution" ->
                Triple(17, 22, "переведено в другие уч. заведения")
            "movedToAnotherSpeciality" ->
                Triple(18, 23, "переведено на др.виды обуч. (внутри колледжа)")
            "contractBreach" ->
                Triple(20, 25, "за нарушение условий Договора")
            "academicDebt" ->
                Triple(21, 26, "за акад. задолженности")
            "notCertified" ->
                Triple(22, 27, "не прошли Итоговую аттестацию")
            "finished" ->
                Triple(23, 28, "закончили обучение")
            "other" ->
                Triple(24, 29, "выбыли по др. причинам")
            else -> null
        }


    private fun renderTableDataTitle() =
        with(sheet) {
            Group::class.memberProperties.forEach {
                val info = getPropertyInformation(it.name) ?: return@forEach

                with((getRow(info.second) ?: createRow(info.second))) {
                    with(createCell(0)) { setCellValue(info.first.toString()); cellStyle = styles.cellStyle }
                    with(createCell(1)) { setCellValue(info.third) }
                    addMergedRegion(CellRangeAddress(info.second, info.second, 1, 2))
                }

            }
        }

    private fun renderTableData(report: Report) =
        with(sheet) {

            var lastRenderedCellGlobalGroup: Int? = null

            report.globalGroup.forEachIndexed { globalGroupIndex, globalGroup ->
                var lastRenderedCellGroup: Int? = if(lastRenderedCellGlobalGroup == null) null else lastRenderedCellGlobalGroup!!

                globalGroup.groups.forEachIndexed { groupIndex, group ->
                    val cellIndex = if(lastRenderedCellGroup == null) 3 + groupIndex else (lastRenderedCellGroup!! + 1)

                    group::class.memberProperties.forEach { member ->
                        val categoryInformation = (member.getter.call(group) as? CategoryInformation) ?: return@forEach

                        val propertyRow = getPropertyRow(member.name)!!

                        with(getRow(propertyRow) ?: createRow(propertyRow)) {
                            with(createCell(cellIndex)) { setCellValue(categoryInformation.budget.toString()); cellStyle = styles.cellStyle }
                            with(createCell(cellIndex + 1)) { setCellValue(categoryInformation.commercial.toString()); cellStyle = styles.cellStyle }
                        }
                    }

                    lastRenderedCellGroup = cellIndex + 1

                }
                lastRenderedCellGlobalGroup = lastRenderedCellGroup
            }
        }

    private val resultFields = listOf(
        Triple(1, 6, "Количество групп"),
        Triple(4, 9, "Число студентов на 1:"),
        Triple(5, 10, "в том числе:"),
        Triple(9, 14, "Прибыло всего человек:"),
        Triple(10, 15, "в том числе:"),
        Triple(15, 20, "Выбыло всего:"),
        Triple(16, 21, "в том числе:"),
        Triple(19, 24, "призваны в ряды РА"),
    )

    private fun renderResultData(report: Report) =
        with(sheet) {
            resultFields.forEach { triple ->
                with(getRow(triple.second) ?: createRow(triple.second)) {
                    with(createCell(0)) { setCellValue(triple.first.toString()); cellStyle = styles.cellStyle }
                    with(createCell(1)) { setCellValue(triple.third) }
                    addMergedRegion(CellRangeAddress(triple.second, triple.second, 1, 2))

                    for(i in 3 .. report.globalGroup.size * 4 + 2) {
                        with(createCell(i)) { setCellValue("0"); cellStyle = styles.cellStyle }
                    }

                }
            }
        }

    private fun renderTable(report: Report) =
        with(sheet) {
            renderPrefixInfoColumns(report)
            renderGeneralGroup(report)
            renderGroup(report)
            renderGroupStudentBudgetOrCommercial(report)
            renderTableDataTitle()
            renderTableData(report)

            renderResultData(report)
        }

    fun renderNumericData(report: Report, index: Int): XSSFSheet {

        renderTableTitle(report)
        renderTable(report)

        sheet.setColumnWidth(0, 1000)
        sheet.setColumnWidth(1, 8000)

        sheet.mergedRegions.forEach { rangeAddress ->
            RegionUtil.setBorderTop(BorderStyle.THIN, rangeAddress, sheet)
            RegionUtil.setBorderLeft(BorderStyle.THIN, rangeAddress, sheet)
            RegionUtil.setBorderRight(BorderStyle.THIN, rangeAddress, sheet)
            RegionUtil.setBorderBottom(BorderStyle.THIN, rangeAddress, sheet)
        }

        return sheet
    }

    fun write() {
        val ops = FileOutputStream(parsedFile)
        fact.write(ops)
        ops.close()
    }
}
