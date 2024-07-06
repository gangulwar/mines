package presentation.ui.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import di.MyKoinComponent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import utils.Colors
import utils.GameState
import utils.INTER_FONT_FAMILY

@Composable
fun MenuOptions() {

    val koinComponent = remember { MyKoinComponent() }

    val currentProfitMultiplier by koinComponent.GameViewModel.currentProfitMultiplier.collectAsState()

    val currentProfit by koinComponent.GameViewModel.currentProfitAmount.collectAsState()

    var minesCount by remember { mutableStateOf("1") }

    val isBetStarted = GameState.betStarted

    var betAmount by remember { mutableStateOf("0.000") }

    var coroutineScope = rememberCoroutineScope()

    Text(
        modifier = Modifier,
        text = "Bet Amount",
        style = TextStyle(
            fontFamily = INTER_FONT_FAMILY,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 25.sp,
            color = Colors.TEXT
        )
    )

    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(10.dp)
            .shadow(5.dp, RoundedCornerShape(10.dp))
            .background(Colors.MENU_BG, RoundedCornerShape(10.dp)),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        TextField(
            modifier = Modifier
                .padding(10.dp)
                .width(290.dp),
            value = betAmount,
            onValueChange = {
                if (it.isEmpty()) {
                    betAmount = "0.000"
                } else if (it.toFloat() <= GameState.currentPoints) {
                    betAmount = it
                }
            },
            textStyle = TextStyle(
                fontFamily = INTER_FONT_FAMILY,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                color = Colors.TEXT
            ),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                backgroundColor = Colors.MAIN_BG,
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            )
        )

        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(start = 10.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .padding(end = 10.dp)
                    .clickable(interactionSource = MutableInteractionSource(),
                        indication = null,
                        onClick = {
                            if (betAmount.toFloat() / 2 > 0) {
                                betAmount = (betAmount.toFloat() / 2).toString()
                            } else {
                                betAmount = "0.000"
                            }
                        }
                    ),
                text = "1/2",
                style = TextStyle(
                    fontFamily = INTER_FONT_FAMILY,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 15.sp,
                    color = Colors.TEXT
                )
            )

            Box(
                modifier = Modifier.padding(start = 15.dp, end = 15.dp)
                    .height(20.dp)
                    .width(5.dp)
                    .background(Color(29, 49, 61))
            )

            Text(
                modifier = Modifier.padding(start = 10.dp)
                    .clickable(interactionSource = MutableInteractionSource(),
                        indication = null,
                        onClick = {
                            if (betAmount.toFloat() * 2 >= GameState.currentPoints) {
                                betAmount = GameState.currentPoints.toString()
                            } else {
                                betAmount = (betAmount.toFloat() * 2).toString()
                            }
                        }
                    ),
                text = "2x",
                style = TextStyle(
                    fontFamily = INTER_FONT_FAMILY,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 15.sp,
                    color = Colors.TEXT
                )
            )
        }

    }

    Text(
        modifier = Modifier,
        text = "Mines",
        style = TextStyle(
            fontFamily = INTER_FONT_FAMILY,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 25.sp,
            color = Colors.TEXT
        )
    )

    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(10.dp)
            .shadow(5.dp, RoundedCornerShape(10.dp))
            .background(Colors.MENU_BG, RoundedCornerShape(10.dp)),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        TextField(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            value = minesCount,
            onValueChange = {
                if (it.isEmpty()) {
                    minesCount = 1.toString()
                } else if (it.toInt() < 25) {
                    minesCount = it
                }
            },

            textStyle = TextStyle(
                fontFamily = INTER_FONT_FAMILY,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                color = Colors.TEXT

            ),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                backgroundColor = Colors.MAIN_BG,
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
    }

    if (isBetStarted) {
        Text(
            modifier = Modifier,
            text = "Total Profit (${currentProfitMultiplier}x)",
            style = TextStyle(
                fontFamily = INTER_FONT_FAMILY,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 25.sp,
                color = Colors.TEXT
            )
        )

        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(10.dp)
                .shadow(5.dp, RoundedCornerShape(10.dp))
                .background(Colors.MENU_BG, RoundedCornerShape(10.dp)),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            TextField(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                value = currentProfit.toString(),
                onValueChange = {},
                enabled = false,
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    backgroundColor = Colors.MAIN_BG,
                ),
                textStyle = TextStyle(
                    fontFamily = INTER_FONT_FAMILY,
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp,
                    color = Colors.TEXT
                )
            )
        }
    }

    Button(
        modifier = Modifier.fillMaxWidth()
            .padding(20.dp)
            .shadow(5.dp, RoundedCornerShape(10.dp)),
        onClick = {
//            isBetStarted = true
            if (!isBetStarted) {
                GameState.betStarted = true
                koinComponent.GameViewModel.setUpGame(totalMines = minesCount.toInt(), betAmount = betAmount.toFloat())
            } else {
                coroutineScope.launch {
                    koinComponent.GameViewModel.checkOutGame()
                }
//                koinComponent.GameViewModel.checkOutGame()
            }

        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Colors.BUTTON,
            contentColor = Color.White
        )
    ) {
        Text(
            modifier = Modifier.padding(10.dp),
            text = if (!isBetStarted) {
                "Bet"
            } else {
                "Checkout"
            },
            style = TextStyle(
                fontFamily = INTER_FONT_FAMILY,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 25.sp,
                color = Color.Black
            )
        )
    }
}