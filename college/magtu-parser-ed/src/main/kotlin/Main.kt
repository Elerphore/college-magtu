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
import userInterface.UserInterface
import userInterface.components.MainWindow
import java.awt.Dimension
import java.io.File
import javax.swing.JFileChooser

fun main() = application {
    val mainWindow: MainWindow = MainWindow()

    Window(
        onCloseRequest = ::exitApplication,
    ) {
        this.window.size = Dimension(1000, 650)
        UserInterface(
            mainWindow = mainWindow
        ).render()
    }
}
