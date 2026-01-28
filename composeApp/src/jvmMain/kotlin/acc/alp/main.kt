package acc.alp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "proyecto_intermodular_acc_alp_frontend",
    ) {
        App()
    }
}