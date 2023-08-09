package presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun BirdScreen(viewModel: BirdViewModel) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) {

        val modifier = Modifier.padding(it)
        val state by viewModel.uiState.collectAsState()

        if (state.isLoading) {
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(state.birdImages) {
                    KamelImage(
                        modifier = modifier.fillMaxSize(),
                        resource = asyncPainterResource("https://sebi.io/demo-image-api/${it.path}"),
                        contentDescription = null,
                        onLoading = {
                            CircularProgressIndicator(
                                modifier = modifier.size(16.dp),
                                strokeWidth = 1.dp
                            )
                        },
                    )
                }
            }
        }
    }
}