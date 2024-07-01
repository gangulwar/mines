package utils

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font

val INTER_FONT_FAMILY by lazy { FontLoader().loadInterFontFamily() }

class FontLoader {
    fun loadInterFontFamily(): FontFamily {
        return FontFamily(
            Font("fonts/inter_extrabold.ttf", FontWeight.ExtraBold),
            Font("fonts/inter_regular.ttf", FontWeight.Normal),
            Font("fonts/inter_semibold.ttf", FontWeight.SemiBold)
        )
    }
}