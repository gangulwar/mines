import androidx.compose.ui.window.*
import di.viewModelModule
import presentation.ui.App
import org.koin.core.context.startKoin


fun main() = application {

    startKoin {
        modules(viewModelModule)
    }

    val windowState = rememberWindowState()

    windowState.placement = WindowPlacement.Maximized

    Window(
        onCloseRequest = ::exitApplication, state = windowState
    ) {
        App()
    }
}
