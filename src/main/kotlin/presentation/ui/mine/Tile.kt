package presentation.ui.mine

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.unit.dp
import di.MyKoinComponent
import presentation.viewmodel.GameViewModel
import utils.Colors
import utils.Path
import java.io.File


@Preview
@Composable
fun Tile(
    gameViewModel: GameViewModel,
    tilePosition: Int
) {
    val koinComponent = remember { MyKoinComponent() }

//    val tileStates by koinComponent.TileViewModel.selectedTiles


    var selected by remember { mutableStateOf(false) }
    var tileWithMine by remember { mutableStateOf(false) }

    Box {

        if (!selected) {
            Box(
                modifier = Modifier
                    .size(125.dp)
                    .shadow(15.dp, RoundedCornerShape(10.dp), ambientColor = Color(33, 55, 67))
                    .background(Color(33, 55, 67), RoundedCornerShape(10.dp))
            )
        }

        Box(
            modifier = Modifier
                .offset(x = (-5).dp, y = (-10).dp)
                .padding(5.dp)
                .size(125.dp)
                .shadow(15.dp, RoundedCornerShape(10.dp), ambientColor = Color(33, 55, 67))
                .background(
                    if (selected) {
                        Colors.DAIMOND_TILE_BG
                    } else
                        Colors.TILE, RoundedCornerShape(10.dp)
                )
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null,
                    onClick = {
                        tileWithMine = gameViewModel.checkMine(tilePosition)
                        selected = true
                    }
                )
        )

        if (selected && !tileWithMine) {
            Image(
                modifier = Modifier
                    .offset(x = (-5).dp, y = (-10).dp)
                    .align(Alignment.Center),
                painter = BitmapPainter(
                    loadImageBitmap(
                        File(Path.DIAMOND).inputStream()
                    )
                ),
                contentDescription = "DIAMOND TILE",
            )
        } else if (selected) {
            Image(
                modifier = Modifier
                    .offset(x = (-5).dp, y = (-10).dp)
                    .align(Alignment.Center),
                painter = BitmapPainter(
                    loadImageBitmap(
                        File(Path.MINE).inputStream()
                    )
                ),
                contentDescription = "MINE TILE",
            )
        }
    }
}