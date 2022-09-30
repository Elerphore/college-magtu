import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import userInterface.UserInterface
import java.awt.Dimension

fun main() = application {
    Window(title = "Отчётная система МПК", onCloseRequest = ::exitApplication) {
        this.window.size = Dimension(1000, 650)
        UserInterface().render()
    }
}
