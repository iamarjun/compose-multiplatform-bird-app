package presentation

import BaseViewModel
import kotlinx.coroutines.launch
import usecases.GetBirdList

class BirdViewModel(private val getBirdList: GetBirdList) :
    BaseViewModel<BirdScreenContract.Event, BirdScreenContract.State, BirdScreenContract.Effect>() {
    override fun createInitialState(): BirdScreenContract.State {
        return BirdScreenContract.State()
    }

    override fun handleEvent(event: BirdScreenContract.Event) {
        when (event) {

            else -> {}
        }
    }

    init {
        viewModelScope.launch {
            setState {
                copy(
                    isLoading = true
                )
            }
            getBirdList()
                .onSuccess {
                    setState {
                        copy(
                            isLoading = false,
                            birdImages = it
                        )
                    }
                }
                .onFailure {
                    setState {
                        copy(
                            isLoading = false,
                        )
                    }

                    setEffect {
                        BirdScreenContract.Effect.ShowToast(it.message ?: "Something went wrong")
                    }
                }
        }
    }


}