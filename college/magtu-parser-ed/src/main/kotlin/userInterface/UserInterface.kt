package userInterface

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import userInterface.components.MainWindow
import java.io.File
import javax.swing.JFileChooser

class UserInterface(
    val mainWindow: MainWindow
) {

    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    @Preview
    private fun renderInputForm() {
        var text by remember { mutableStateOf("") }
        var showReport by remember { mutableStateOf(false) }
        var chooser by remember { mutableStateOf(JFileChooser()) }
        var dataFile by remember { mutableStateOf(File("")) }

        this.mainWindow.renderMain(
            text = text,
            showReport = showReport,
            chooser = chooser,
            onChangeText = { text = it },
            onChangeReport = { showReport = it },
            dataFile = dataFile,
            onDataFileChange = { file ->
                dataFile = file
                println(dataFile.name)
            },
        )
    }

    @Composable
    fun render() = renderInputForm()
}
