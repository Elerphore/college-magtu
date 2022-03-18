// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import java.awt.Dimension
import java.io.File
import javax.swing.JFileChooser

@OptIn(ExperimentalComposeUiApi::class)
@Composable
@Preview
fun App() {
    val chooser = javax.swing.JFileChooser()

    MaterialTheme {
        var consumedText by remember { mutableStateOf(0) }
        var text by remember { mutableStateOf("") }

        Column(Modifier.fillMaxWidth().padding(top = 30.dp), Arrangement.spacedBy(10.dp), Alignment.CenterHorizontally) {
            Row(Modifier.fillMaxWidth(0.9F), Arrangement.spacedBy(10.dp), Alignment.CenterVertically) {
                TextField(
                    label = { Text("Отделение") },
                    modifier = Modifier.fillMaxWidth(),
                    value = text,
                    onValueChange = { text = it },
                    singleLine = true
                )
            }

            Row(Modifier.fillMaxWidth(0.9F), Arrangement.spacedBy(10.dp), Alignment.CenterVertically) {
                TextField(
                    label = { Text("Группа") },
                    modifier = Modifier.fillMaxWidth(),
                    value = text,
                    onValueChange = { text = it },
                    singleLine = true
                )
            }

            Row(Modifier.fillMaxWidth(0.9F), Arrangement.spacedBy(10.dp), Alignment.CenterVertically) {
                TextField(
                    label = { Text("Приказ") },
                    modifier = Modifier.fillMaxWidth(1.0F),
                    value = text,
                    onValueChange = { text = it },
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

            val checkedState = remember { mutableStateOf(true) }
            Row(Modifier.fillMaxWidth(0.9F), Arrangement.spacedBy(10.dp), Alignment.CenterVertically) {
                Checkbox(
                    checked = checkedState.value,
                    onCheckedChange = { checkedState.value = it }
                )
                Text(text = "Добавить приказ")
            }

            if(checkedState.value) {
                Row(Modifier.fillMaxWidth(0.9F), Arrangement.spacedBy(10.dp), Alignment.CenterVertically) {
                    TextField(
                        label = { Text("Приказ") },
                        modifier = Modifier.fillMaxWidth(1.0F),
                        value = text,
                        onValueChange = { text = it },
                        singleLine = true
                    )
                }

                Row(Modifier.fillMaxWidth(0.9F), Arrangement.spacedBy(10.dp), Alignment.CenterVertically) {
                    TextField(
                        label = { Text("Приказ") },
                        modifier = Modifier.fillMaxWidth(1.0F),
                        value = text,
                        onValueChange = { text = it },
                        singleLine = true
                    )
                }

                Row(Modifier.fillMaxWidth(0.9F), Arrangement.spacedBy(10.dp), Alignment.CenterVertically) {
                    TextField(
                        label = { Text("Приказ") },
                        modifier = Modifier.fillMaxWidth(1.0F),
                        value = text,
                        onValueChange = { text = it },
                        singleLine = true
                    )
                }

                Row(Modifier.fillMaxWidth(0.9F), Arrangement.spacedBy(10.dp), Alignment.CenterVertically) {
                    Button(
                        modifier = Modifier.fillMaxWidth(1.0F),
                        onClick = {

                        }
                    ) {
                        Text("Start")
                    }
                }

            }

        }
    }
}

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
    ) {
        this.window.size = Dimension(1000, 1000)
        App()
    }
}
