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
        var text by remember { mutableStateOf("") }
        var showReport by remember { mutableStateOf(false) }
        var chooser by remember { mutableStateOf(JFileChooser()) }

        this.mainWindow.renderMain(
            text = text,
            showReport = showReport,
            chooser = chooser,
            onChangeText = { text = it },
            onChangeReport = { showReport = it },
            onChangeFile = { chooser = it }
        )
    }

    @Composable
    fun render() = renderInputForm()
}
