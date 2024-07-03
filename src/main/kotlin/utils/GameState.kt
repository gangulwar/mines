package utils

import androidx.compose.runtime.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object GameState {
    var currentPoints by mutableStateOf(1000f)
    var betAmount = 0

    var betStarted by mutableStateOf(false)

}

