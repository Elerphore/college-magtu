package parser

import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.ss.usermodel.WorkbookFactory
import parser.utils.Department
import parser.utils.DepartmentUtils
import parser.utils.Specification
import parser.utils.SpecificationUtils
import java.io.File

class Parser {
fun drawSomeData() {
        val file = File("/home/elerphore/Downloads/form.xlsx")
        val factory: Workbook? = WorkbookFactory.create(file)

        factory?.let { workBook ->

            workBook.forEach { sheet ->
                when(sheet.sheetName) {
                    Department.DEP_ONE.deptName,
                    Department.DEP_TWO.deptName,
                    Department.DEP_THREE.deptName,
                    Department.DEP_FOUR.deptName -> {
                        DepartmentUtils().parse(sheet)
                    }

                    Specification.SPECIALTIES.speciality,
                    Specification.ENLARGED.speciality,
                    Specification.RESULT.speciality -> {
                        SpecificationUtils().parse(sheet)
                    }

                    else -> {
                        println("Not an important data")
                    }
                }
            }

        }
    }
}
