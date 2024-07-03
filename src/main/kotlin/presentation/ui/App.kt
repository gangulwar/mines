package presentation.ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import presentation.ui.menu.Menu
import presentation.ui.mine.MinesView
import utils.Colors
import utils.GameState
import utils.INTER_FONT_FAMILY

@OptIn(ExperimentalLayoutApi::class)
@Composable
@Preview
fun App() {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth()
                    .height(65.dp),
                title = {

                    val totalPoints = GameState.currentPoints

                    Box(
                        modifier = Modifier.fillMaxWidth()
                            .padding(top = 5.dp, bottom = 5.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            modifier = Modifier
                                .background(Colors.TILE_BG)
                                .padding(15.dp),
                            text = "₹ $totalPoints",
                            style = TextStyle(
                                fontFamily = INTER_FONT_FAMILY,
                                fontWeight = FontWeight.ExtraBold,
                                color = Colors.TEXT,
                                fontSize = 15.sp
                            )
                        )
                    }
                },
                backgroundColor = Colors.MAIN_BG,
                elevation = 0.dp
            )
        }
    ) {
        Row(
            modifier = Modifier.fillMaxSize()
                .background(Colors.MAIN_BG)
        ) {

            Menu()

            MinesView()
        }
    }
}