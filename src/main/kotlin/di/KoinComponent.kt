package di

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.dsl.module
import presentation.viewmodel.GameViewModel
import presentation.viewmodel.TileViewModel

class MyKoinComponent : KoinComponent {
    val GameViewModel: GameViewModel by inject()
    val TileViewModel: TileViewModel by inject()
}

val viewModelModule = module {
    single { GameViewModel() }
    single { TileViewModel() }
}
