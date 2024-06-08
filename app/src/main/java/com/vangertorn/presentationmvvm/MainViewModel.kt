package com.vangertorn.presentationmvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vangertorn.presentationmvvm.utils.mapState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val state = MutableStateFlow(
        MainStateModel(firstValue = 0, secondValue = 0, firstValueLoading = true, secondValueLoading = true)
    )

    init {
        launchFirstCoeff()
        launchSecondCoeff()
    }

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

    private fun launchFirstCoeff() {
        viewModelScope.launch {
            delay(3000)
            state.update { stateModel -> stateModel.copy(firstValue = 7, firstValueLoading = false) }
        }
    }

    private fun launchSecondCoeff() {
        viewModelScope.launch {
            delay(8000)
            state.update { stateModel -> stateModel.copy(secondValue = -3, secondValueLoading = false) }
        }
    }
}