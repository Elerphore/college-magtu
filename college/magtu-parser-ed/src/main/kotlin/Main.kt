import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import parser.Parser
import java.io.File
import javax.swing.JFileChooser

fun main() = application {
    Window(title = "Отчётная система МПК", onCloseRequest = ::exitApplication) {
        MaterialTheme {
            renderMain()
        }
    }
}

@Composable
fun renderMain() {
    var dataFile by remember { mutableStateOf(File("")) }
    val onDataFileChange: (File) -> Unit = { file -> dataFile = file }
    val chooser by remember { mutableStateOf(JFileChooser()) }
    var showReport by remember { mutableStateOf(false) }
    val onChangeReport: (Boolean) -> Unit = { showReport = it }

    var text by remember { mutableStateOf("") }
    val onChangeText: (String) -> Unit = { text = it }

    Column(
        Modifier.fillMaxWidth().padding(top = 30.dp).verticalScroll(rememberScrollState()),
        Arrangement.spacedBy(10.dp),
        Alignment.CenterHorizontally
    ) {
        renderMainInputs(
            showReport = showReport,
            chooser = chooser,
            onChangeReport = onChangeReport,
            onDataFileChange = onDataFileChange
        )

        if (showReport) { renderReport(text, onChangeText) }

        renderButton(dataFile)
    }
}

@Composable
private fun renderButton(dataFile: File) =
    Row(Modifier.fillMaxWidth(0.9F), Arrangement.spacedBy(10.dp), Alignment.CenterVertically) {
        Button(modifier = Modifier.fillMaxWidth(1.0F), onClick = { Parser.renderExcelFile(dataFile) }) {
            Text("Сгенерировать файл")
        }
    }

@Composable
private fun renderTextButtonGroupField(
    placeholder: String,
    chooser: JFileChooser,
    onDataFileChange: (File) -> Unit,
) = Row(Modifier.fillMaxWidth(0.9F), Arrangement.spacedBy(10.dp), Alignment.CenterVertically) {
    var currentJsonDataFileName by remember { mutableStateOf("") }

    TextField(
        label = { Text(placeholder) },
        modifier = Modifier.fillMaxWidth(0.6F),
        value = currentJsonDataFileName,
        readOnly = true,
        onValueChange = { },
        singleLine = true
    )

    renderChooserButton(chooser, onDataFileChange) { currentJsonDataFileName = it }
}

@Composable
private fun typeReportSelectable(placeholder: String, onTextFieldChange: (String) -> Unit) =
    Row(Modifier.fillMaxWidth(0.9F), Arrangement.spacedBy(10.dp), Alignment.CenterVertically) {
        var expanded by remember { mutableStateOf(false) }

        val options = listOf("Зачисление", "Отчисление", "Академический отпуск")

        TextField(
            label = { Text("Тип приказа") },
            modifier = Modifier.fillMaxWidth().onFocusChanged { expanded = it.hasFocus },
            value = placeholder,
            onValueChange = onTextFieldChange,
            readOnly = true,
            singleLine = true,
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            content = {
                options.forEachIndexed { index, s ->
                    DropdownMenuItem(
                        content = { Text(s) },
                        onClick = { onTextFieldChange(options[index]) }
                    )
                }
            }
        )

    }

@Composable
fun groupReportSelectable(groupName: String, onGroupNameChange: (String) -> Unit) =
    Row(Modifier.fillMaxWidth(0.9F), Arrangement.spacedBy(10.dp), Alignment.CenterVertically) {
        var expanded by remember { mutableStateOf(false) }

        val options = listOf("ИСп-19-1", "ИСп-19-2", "ИСп-19-3", "ИСп-19-4")

        TextField(
            label = { Text("Группа") },
            modifier = Modifier.fillMaxWidth().onFocusChanged { expanded = it.hasFocus },
            value = groupName,
            onValueChange = onGroupNameChange,
            singleLine = true,
            readOnly = true,
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            content = {
                options.forEachIndexed { index, s ->
                    DropdownMenuItem(
                        content = { Text(s) },
                        onClick = { onGroupNameChange(options[index]) }
                    )
                }
            }
        )

    }

@Composable
fun studentNameField(studentName: String, onStudentNameChange: (String) -> Unit) =
    Row(Modifier.fillMaxWidth(0.9F), Arrangement.spacedBy(10.dp), Alignment.CenterVertically) {
        var expanded by remember { mutableStateOf(false) }
        TextField(
            label = { Text("Ф.И.О Студента") },
            modifier = Modifier.fillMaxWidth().onFocusChanged { expanded = it.hasFocus },
            value = studentName,
            onValueChange = onStudentNameChange,
            singleLine = true,
        )
    }


@Composable
private fun renderChooserButton(
    chooser: JFileChooser,
    onDataFileChange: (File) -> Unit,
    onValueChange: (String) -> Unit,
) =
    Button(modifier = Modifier.fillMaxWidth().fillMaxWidth(0.4F),
        onClick = {
            chooser.apply {
                val state = showSaveDialog(null)
                onDataFileChange(this.selectedFile)
                this.selectedFile.let { onValueChange(it.name) }
            }
        }) { Text("Выбрать файл") }

@Composable
private fun renderMainInputs(
    showReport: Boolean,
    chooser: JFileChooser,
    onChangeReport: (Boolean) -> Unit,
    onDataFileChange: (File) -> Unit,
) =
    Column(
        Modifier.fillMaxWidth().padding(top = 30.dp),
        Arrangement.spacedBy(10.dp),
        Alignment.CenterHorizontally
    ) {
        renderTextButtonGroupField("Текущие данные", chooser, onDataFileChange)
        renderTextButtonGroupField("Прошлая таблица", chooser, onDataFileChange)
        renderCheckboxField(showReport, onChangeReport)
    }

@Composable
private fun renderCheckboxField(showReport: Boolean, onChangeReport: (Boolean) -> Unit) =
    Row(Modifier.fillMaxWidth(0.9F), Arrangement.spacedBy(10.dp), Alignment.CenterVertically) {
        Checkbox(checked = showReport, onCheckedChange = onChangeReport)
        Text(text = "Добавить приказ")
    }

@Composable
private fun renderReport(
    text: String,
    onTextFieldChange: (String) -> Unit,
) {
    var reportCount by remember { mutableStateOf(2) }

    Text("Количество приказов: $reportCount")

    LazyColumn(
        modifier = Modifier.height(320.dp),
    ) {
        items(reportCount) {
            var groupName by remember { mutableStateOf("") }
            val onGroupNameChange: (String) -> Unit = { newName -> groupName = newName }

            var studentName by remember { mutableStateOf("") }
            val onStudentNameChange: (String) -> Unit = { newName -> studentName = newName }

            Text("${it + 1} приказ")
            typeReportSelectable(placeholder = text, onTextFieldChange = onTextFieldChange)
            groupReportSelectable(groupName, onGroupNameChange)
            studentNameField(studentName, onStudentNameChange)
            Spacer(modifier = Modifier.height(20.0.dp))
        }
    }

    Button(
        onClick = { reportCount++; },
        modifier = Modifier.fillMaxWidth(0.9f)
    ) {
        Text("Добавить приказ")
    }

    Button(
        onClick = { if (reportCount > 1) reportCount--; },
        modifier = Modifier.fillMaxWidth(0.9f)
    ) {
        Text("Убрать приказ")
    }
}
