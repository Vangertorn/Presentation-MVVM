package com.vangertorn.presentationmvvm

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {

    private val state = MutableStateFlow(
        MainStateModel(firstValue = 0, secondValue = 0)
    )

    fun getState(): StateFlow<MainStateModel> = state

    fun onFirstButtonIncreaseClick() {
        state.update { stateModel ->
            stateModel.copy(firstValue = stateModel.firstValue + 1)
        }
    }

    fun onFirstButtonDecreaseClick() {
        state.update { stateModel ->
            stateModel.copy(firstValue = stateModel.firstValue - 1)
        }
    }

    fun onSecondButtonIncreaseClick() {
        state.update { stateModel ->
            stateModel.copy(secondValue = stateModel.secondValue + 1)
        }
    }

    fun onSecondButtonDecreaseClick() {
        state.update { stateModel ->
            stateModel.copy(secondValue = stateModel.secondValue - 1)
        }
    }
}