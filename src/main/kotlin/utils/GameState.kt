package utils

import androidx.compose.runtime.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object GameState {
    var currentPoints by mutableStateOf(1000f)
    var betAmount = 0

    var lastMultipier = 1.0f
    var lstProfitAmount = 0.0f
    var lastMinesPosition: ArrayList<Int> =ArrayList()
    var lastSelectedTiles: List<Int> = emptyList()


    var betStarted by mutableStateOf(false)

    var enableMinesClicks by mutableStateOf(false)
}

