package com.vangertorn.presentationmvvm

import androidx.lifecycle.ViewModel
import com.vangertorn.presentationmvvm.utils.mapState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {

    private val state = MutableStateFlow(
        MainStateModel(firstValue = 0, secondValue = 0)
    )

    fun getState(): StateFlow<MainUiState> = state.mapState { state ->
        state.toMainUiStateMapper()
    }

    fun onFirstButtonIncreaseClick() {
        state.update { stateModel ->
            stateModel.copy(
                firstValue = if (stateModel.firstValue >= 25) stateModel.firstValue else stateModel.firstValue + 1
            )
        }
    }

    fun onFirstButtonDecreaseClick() {
        state.update { stateModel ->
            stateModel.copy(
                firstValue = if (stateModel.firstValue <= -5) stateModel.firstValue else stateModel.firstValue - 1
            )
        }
    }

    fun onSecondButtonIncreaseClick() {
        state.update { stateModel ->
            stateModel.copy(
                secondValue = if (stateModel.secondValue >= 25) stateModel.secondValue else stateModel.secondValue + 1
            )
        }
    }

    fun onSecondButtonDecreaseClick() {
        state.update { stateModel ->
            stateModel.copy(
                secondValue = if (stateModel.secondValue <= -5) stateModel.secondValue else stateModel.secondValue - 1
            )
        }
    }
}