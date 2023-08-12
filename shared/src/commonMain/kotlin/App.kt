import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import org.koin.compose.getKoin
import presentation.BirdScreen
import presentation.BirdViewModel
import usecases.GetBirdList

@Composable
fun App() {
    MaterialTheme {
        val getBirdList: GetBirdList = getKoin().get()
        val viewModel = getViewModel(Unit, viewModelFactory { BirdViewModel(getBirdList) })
        BirdScreen(viewModel)
    }
}