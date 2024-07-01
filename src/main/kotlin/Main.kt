import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import utils.Colors
import utils.FontLoader
import utils.INTER_FONT_FAMILY

@Composable
@Preview
fun App() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mines", fontFamily = INTER_FONT_FAMILY, fontWeight = FontWeight.ExtraBold) },
                backgroundColor = Color.White
            )
        }
    ){

    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
