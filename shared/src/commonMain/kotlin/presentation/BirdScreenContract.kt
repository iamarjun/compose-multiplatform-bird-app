package presentation

import UiEffect
import UiEvent
import UiState
import model.Bird

object BirdScreenContract {

    sealed class Event : UiEvent {
    }

    sealed class Effect : UiEffect {
        data class ShowToast(val message: String) : Effect()
    }

    data class State(
        val isLoading: Boolean = false,
        val birdImages: List<Bird> = emptyList()
    ) : UiState
}