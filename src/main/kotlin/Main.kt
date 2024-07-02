import androidx.compose.ui.window.*
import presentation.ui.App


fun main() = application {

    val windowState = rememberWindowState()

    windowState.placement = WindowPlacement.Maximized

    Window(
        onCloseRequest = ::exitApplication, state = windowState
    ) {
        App()
    }
}
