import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import network.BirdApi
import org.jetbrains.compose.resources.ExperimentalResourceApi
import presentation.BirdScreen
import presentation.BirdViewModel
import usecases.GetBirdList

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    MaterialTheme {
        val httpClient = HttpClient {
            install(ContentNegotiation) {
                json()
            }
        }
        val birdApi = BirdApi(httpClient)
        val getBirdList = GetBirdList(birdApi)
        val viewModel = getViewModel(Unit, viewModelFactory { BirdViewModel(getBirdList) })
        BirdScreen(viewModel)
    }
}

expect fun getPlatformName(): String