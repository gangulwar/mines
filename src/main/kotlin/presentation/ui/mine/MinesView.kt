package presentation.ui.mine

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import di.MyKoinComponent
import utils.Colors
import utils.GameState
import utils.INTER_FONT_FAMILY

@Composable
fun MinesView() {
    val koinComponent = remember { MyKoinComponent() }
    val gameViewModel = koinComponent.GameViewModel

    val profitMultiplier by gameViewModel.currentProfitMultiplier.collectAsState()
    val profitAmount by gameViewModel.currentProfitAmount.collectAsState()

    val showMultiplierDialog by gameViewModel.multiplierDialog.collectAsState()

    Column(
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight()
            .padding(start = 10.dp, end = 10.dp),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .fillMaxHeight()
//                        .padding(20.dp)
                .background(Colors.TILE_BG, RoundedCornerShape(10.dp)),
        ) {

            Box(
                contentAlignment = Alignment.Center,
            ) {

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .alpha(
                            if (!showMultiplierDialog) {
                                1f
                            } else {
                                0.5f
                            }
                        )
                        .padding(top = 10.dp, bottom = 10.dp)
                ) {
                    for (i in 0 until 5) {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            for (j in 0 until 5) {
                                Tile(
                                    gameViewModel = gameViewModel,
                                    tilePosition = (i * 5) + j,
                                    showMultiplierDialog = showMultiplierDialog
                                ) {
                                    gameViewModel.setMultiplierDialog(true)
                                }

                                if (j < 4) {
                                    Spacer(modifier = Modifier.size(4.dp))
                                }
                            }
                        }

                        if (i < 4) {
                            Spacer(modifier = Modifier.size(4.dp))
                        }
                    }
                }


                if (showMultiplierDialog) {
                    CheckoutDialog()
                }

            }
        }
    }
}


@Preview
@Composable
fun CheckoutDialog() {
    Card(
        modifier = Modifier.width(180.dp).height(125.dp),
        backgroundColor = Colors.MAIN_BG,
        shape = RoundedCornerShape(15.dp),
        border = BorderStroke(3.dp, Color(0, 225, 2))
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "${GameState.lastMultipier}x",
                style = TextStyle(
                    fontFamily = INTER_FONT_FAMILY,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 25.sp,
                    color = Color.Green
                )
            )

            Divider(
                color = Colors.TILE,
                thickness = 2.dp,
                modifier = Modifier.padding(
                    start = 55.dp, end = 55.dp,
                    top = 10.dp, bottom = 10.dp
                )
            )

            Text(
                text = GameState.lstProfitAmount.toString(),
                style = TextStyle(
                    fontFamily = INTER_FONT_FAMILY,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 15.sp,
                    color = Color.Green
                )
            )

        }
    }
}