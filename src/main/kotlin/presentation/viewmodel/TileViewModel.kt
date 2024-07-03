package presentation.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class TileViewModel : ViewModel() {

    val selectedTiles = mutableStateListOf<Boolean>().apply {
        repeat(25) { add(false) }
    }

    fun selectTile(tilePosition: Int) {
        selectedTiles[tilePosition] = true
    }

    fun check(tilePosition: Int): Boolean {
        return selectedTiles[tilePosition]
    }

    fun resetTiles() {
        for (i in selectedTiles.indices) {
            selectedTiles[i] = false
        }
    }

}