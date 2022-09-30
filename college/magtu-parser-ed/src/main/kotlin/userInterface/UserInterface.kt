package userInterface

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import userInterface.components.MainWindow

class UserInterface {
    @Composable
    fun render() = MaterialTheme { MainWindow().renderMain() }
}
