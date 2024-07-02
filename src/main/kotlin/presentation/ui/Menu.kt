package presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import utils.Colors
import utils.INTER_FONT_FAMILY

@Composable
fun Menu() {
    Column(
        modifier = Modifier.fillMaxWidth(0.35f)
            .fillMaxHeight()
            .padding(start = 10.dp, end = 10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
                .background(Colors.MENU_BG, RoundedCornerShape(10.dp)),
        ) {

            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.Start
            ) {
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
                        value = "",
                        onValueChange = {},
                        colors = TextFieldDefaults.textFieldColors(
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            backgroundColor = Colors.MAIN_BG,
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
                                .padding(end = 10.dp),
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
                            modifier = Modifier.padding(start = 10.dp),
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
                        value = "",
                        onValueChange = {},
                        colors = TextFieldDefaults.textFieldColors(
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            backgroundColor = Colors.MAIN_BG,
                        )
                    )
                }

                Button(
                    modifier = Modifier.fillMaxWidth()
                        .padding(20.dp)
                        .shadow(5.dp, RoundedCornerShape(10.dp)),
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Colors.BUTTON,
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        modifier = Modifier.padding(10.dp),
                        text = "Bet",
                        style = TextStyle(
                            fontFamily = INTER_FONT_FAMILY,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 25.sp,
                            color = Color.Black
                        )
                    )
                }
            }
        }
    }
}