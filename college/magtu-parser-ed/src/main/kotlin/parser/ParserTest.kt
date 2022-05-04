package parser

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.junit.jupiter.api.Test
import parser.utils.ExcelUtils
import java.io.File

internal class ParserTest {
    private val mapper = jacksonObjectMapper().apply { this.registerKotlinModule(); this.registerModule(JavaTimeModule()); }
    private val fact = XSSFWorkbook()

    private val excelUtils = ExcelUtils()

    @Test
    fun drawSomeData() =
        File("/home/elerphore/students.json")
            .let {jsFile -> mapper.readValue<Report>(jsFile.readText()) }
            .let { excelUtils.renderNumericData(fact, it) }

}
