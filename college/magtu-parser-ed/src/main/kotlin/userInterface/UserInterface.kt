package userInterface

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
import userInterface.components.MainWindow
import java.awt.Dimension
import java.io.File
import javax.swing.JFileChooser

class UserInterface(
    val mainWindow: MainWindow
) {

    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    @Preview
    private fun renderInputForm() {
//                        var consumedText by remember { mutableStateOf(0) }
        var text by remember { mutableStateOf("") }
        this.mainWindow.renderMain(text) { text = it }
//        val chooser = javax.swing.JFileChooser()
//
//        MaterialTheme {
//                var consumedText by remember { mutableStateOf(0) }
//                var text by remember { mutableStateOf("") }
//
//                Column(Modifier.fillMaxWidth().padding(top = 30.dp), Arrangement.spacedBy(10.dp), Alignment.CenterHorizontally) {
//                    mainWindow.renderMainInputs(text = text) { text = it }
//
//                    val checkedState = remember { mutableStateOf(false) }
//                    Row(Modifier.fillMaxWidth(0.9F), Arrangement.spacedBy(10.dp), Alignment.CenterVertically) {
//                        Checkbox(
//                            checked = checkedState.value,
//                            onCheckedChange = { checkedState.value = it }
//                        )
//                        Text(text = "Добавить приказ")
//                    }
//
//                    if(checkedState.value) {
//                        mainWindow.renderReport(text = text) { text = it }
//                    }
//
//                    Row(Modifier.fillMaxWidth(0.9F), Arrangement.spacedBy(10.dp), Alignment.CenterVertically) {
//                        Button(
//                            modifier = Modifier.fillMaxWidth(1.0F),
//                            onClick = {
//
//                            }
//                        ) {
//                            Text("Start")
//                        }
//                    }
//                }
//
//            }
    }

    @Composable
    fun render() = renderInputForm()
}
