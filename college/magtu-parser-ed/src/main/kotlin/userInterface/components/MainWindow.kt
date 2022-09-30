package userInterface.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import parser.Parser
import java.io.File
import javax.swing.JFileChooser

class MainWindow {
    var text by remember { mutableStateOf("") }
    var showReport by remember { mutableStateOf(false) }
    val chooser by remember { mutableStateOf(JFileChooser()) }
    var dataFile by remember { mutableStateOf(File("")) }

    val onChangeText: (String) -> Unit = { text = it }
    val onChangeReport: (Boolean) -> Unit = { showReport = it }
    val onDataFileChange: (File) -> Unit = { file -> dataFile = file }

    @Composable
    fun renderMain() {
        Column(Modifier.fillMaxWidth().padding(top = 30.dp), Arrangement.spacedBy(10.dp), Alignment.CenterHorizontally) {
            renderMainInputs(showReport = showReport, chooser = chooser, onChangeReport = onChangeReport, onDataFileChange = onDataFileChange)
            if(showReport) renderReport(text, onChangeText);
            renderButton(dataFile)
        }
    }

    @Composable
    private fun renderButton(dataFile: File) =
        Row(Modifier.fillMaxWidth(0.9F), Arrangement.spacedBy(10.dp), Alignment.CenterVertically) {
            Button(modifier = Modifier.fillMaxWidth(1.0F), onClick = { Parser().renderExcelFile(dataFile) }) {
                Text("Сгенерировать файл")
            }
        }

    @Composable
    private fun renderTextButtonGroupField(
        placeholder: String,
        chooser: JFileChooser? = null,
        onDataFileChange: (File) -> Unit
    ) = Row(Modifier.fillMaxWidth(0.9F), Arrangement.spacedBy(10.dp), Alignment.CenterVertically) {
        var currentJsonDataFileName by remember { mutableStateOf("") }
        TextField(label = { Text(placeholder) }, modifier = Modifier.fillMaxWidth(0.6F), value = currentJsonDataFileName, readOnly = true, onValueChange = { }, singleLine = true)

        when(chooser) {
            null -> {}
            else -> renderChooserButton(chooser, onDataFileChange) { currentJsonDataFileName = it }
        }
    }

    @Composable
    private fun renderChooserButton(chooser: JFileChooser, onDataFileChange: (File) -> Unit, onValueChange: (String) -> Unit) =
        Button(modifier = Modifier.fillMaxWidth().fillMaxWidth(0.4F),
            onClick = {
                chooser.apply {
                    val state = showSaveDialog(null)
                    onDataFileChange(this.selectedFile)
                    this.selectedFile.let { onValueChange(it.name) }
                }
            }) { Text("Выбрать файл") }

    @Composable
    private fun renderCheckboxField(showReport: Boolean, onChangeReport: (Boolean) -> Unit) =
        Row(Modifier.fillMaxWidth(0.9F), Arrangement.spacedBy(10.dp), Alignment.CenterVertically) {
            Checkbox(checked = showReport, onCheckedChange = onChangeReport)
            Text(text = "Добавить приказ")
        }

    @Composable
    private fun renderMainInputs(showReport: Boolean, chooser: JFileChooser, onChangeReport: (Boolean) -> Unit, onDataFileChange: (File) -> Unit) =
        Column(Modifier.fillMaxWidth().padding(top = 30.dp), Arrangement.spacedBy(10.dp), Alignment.CenterHorizontally) {
            renderTextButtonGroupField("Текущие данные", chooser, onDataFileChange)
            renderTextButtonGroupField("Прошлая таблица", chooser, onDataFileChange)
            renderCheckboxField(showReport, onChangeReport)
        }

        @Composable
        private fun renderReport(text: String, onTextFieldChange: (String) -> Unit) {
            renderTextButtonGroupField(placeholder = "Приказ", onDataFileChange = { println(it) })
            renderTextButtonGroupField(placeholder = "Приказ", onDataFileChange = { println(it) })
            renderTextButtonGroupField(placeholder = "Приказ", onDataFileChange = { println(it) })
        }
    }
