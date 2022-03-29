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

    @Composable
    fun renderMain(
        text: String,
        showReport: Boolean = false,
        chooser: JFileChooser,
        onChangeText: (String) -> Unit,
        onChangeReport: (Boolean) -> Unit,
        onChangeFile: (JFileChooser) -> Unit,
    ) {

        MaterialTheme {
            Column(Modifier.fillMaxWidth().padding(top = 30.dp), Arrangement.spacedBy(10.dp), Alignment.CenterHorizontally) {
                renderMainInputs(
                    text = text,
                    showReport = showReport,
                    chooser = chooser,
                    onChangeText = onChangeText,
                    onChangeReport = onChangeReport,
                )

                if(showReport) {
                    renderReport(text, onChangeText)
                }

                Row(Modifier.fillMaxWidth(0.9F), Arrangement.spacedBy(10.dp), Alignment.CenterVertically) {
                    Button(
                        modifier = Modifier.fillMaxWidth(1.0F),
                        onClick = {
                            Parser().drawSomeData()
                        }
                    ) {
                        Text("Start")
                    }
                }
            }
        }
    }

    @Composable
    private fun renderMainInputs(
        text: String,
        showReport: Boolean,
        chooser: JFileChooser,
        onChangeText: (String) -> Unit,
        onChangeReport: (Boolean) -> Unit,
    ) {
        Column(
            Modifier.fillMaxWidth().padding(top = 30.dp),
            Arrangement.spacedBy(10.dp),
            Alignment.CenterHorizontally,
        ) {
            Row(Modifier.fillMaxWidth(0.9F), Arrangement.spacedBy(10.dp), Alignment.CenterVertically) {
                TextField(
                    label = { Text("Отделение") },
                    modifier = Modifier.fillMaxWidth(),
                    value = text,
                    onValueChange = onChangeText,
                    singleLine = true
                )
            }

            Row(Modifier.fillMaxWidth(0.9F), Arrangement.spacedBy(10.dp), Alignment.CenterVertically) {
                TextField(
                    label = { Text("Группа") },
                    modifier = Modifier.fillMaxWidth(),
                    value = text,
                    onValueChange = onChangeText,
                    singleLine = true
                )
            }

            Row(Modifier.fillMaxWidth(0.9F), Arrangement.spacedBy(10.dp), Alignment.CenterVertically) {
                TextField(
                    label = { Text("Приказ") },
                    modifier = Modifier.fillMaxWidth(1.0F),
                    value = text,
                    onValueChange = onChangeText,
                    singleLine = true
                )
            }

            Row(Modifier.fillMaxWidth(0.9F), Arrangement.spacedBy(10.dp), Alignment.CenterVertically) {
                var textField by remember { mutableStateOf("") }

                TextField(
                    label = { Text("Прошлая таблица") },
                    modifier = Modifier.fillMaxWidth(0.6F),
                    value = textField,
                    readOnly = true,
                    onValueChange = { },
                    singleLine = true
                )

                Button(
                    modifier = Modifier.fillMaxWidth().fillMaxWidth(0.4F),
                    onClick = {


                        chooser.apply {
                            val state = showSaveDialog(null)
                            val file: File? = this.selectedFile

                            file?.let {
                                textField = it.name
                            }

                            when(state) {
                                JFileChooser.APPROVE_OPTION -> println("APPROVE_OPTION")
                                JFileChooser.CANCEL_OPTION -> println("CANCEL_OPTION")
                                JFileChooser.ERROR_OPTION -> println("ERROR_OPTION")
                            }
                        }

                    },
                ) {
                    Text("Choose")
                }
            }
        }

        Row(Modifier.fillMaxWidth(0.9F), Arrangement.spacedBy(10.dp), Alignment.CenterVertically) {
            Checkbox(
                checked = showReport,
                onCheckedChange = onChangeReport
            )
            Text(text = "Добавить приказ")
        }

    }

        @Composable
        private fun renderReport(text: String, onTextFieldChange: (String) -> Unit) {
            Row(Modifier.fillMaxWidth(0.9F), Arrangement.spacedBy(10.dp), Alignment.CenterVertically) {
                TextField(
                    label = { Text("Приказ") },
                    modifier = Modifier.fillMaxWidth(1.0F),
                    value = text,
                    onValueChange = onTextFieldChange,
                    singleLine = true
                )
            }

            Row(Modifier.fillMaxWidth(0.9F), Arrangement.spacedBy(10.dp), Alignment.CenterVertically) {
                TextField(
                    label = { Text("Приказ") },
                    modifier = Modifier.fillMaxWidth(1.0F),
                    value = text,
                    onValueChange = onTextFieldChange,
                    singleLine = true
                )
            }

            Row(Modifier.fillMaxWidth(0.9F), Arrangement.spacedBy(10.dp), Alignment.CenterVertically) {
                TextField(
                    label = { Text("Приказ") },
                    modifier = Modifier.fillMaxWidth(1.0F),
                    value = text,
                    onValueChange = onTextFieldChange,
                    singleLine = true
                )
            }

        }
    }
