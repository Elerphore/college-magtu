package parser

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import data.ReportItem
import parser.utils.ExcelUtils
import java.io.File

object Parser {

    private val mapper = jacksonObjectMapper().apply {
        this.registerKotlinModule()
        this.registerModule(JavaTimeModule())
    }

    fun renderExcelFile(dataFile: File) =
        dataFile.readText().let {
            val reportItem = mapper.readValue<ReportItem>(it)

            ExcelUtils.renderNumericData(reportItem)
            ExcelUtils.write()
        }

}
