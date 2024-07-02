package presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import utils.Colors

@Composable
fun MinesView(){
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
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(top = 10.dp, bottom = 10.dp)
            ) {
                for (i in 0 until 5) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        for (j in 0 until 5) {
                            Tile()
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
        }
    }
}