package com.vangertorn.presentationmvvm.alternative

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vangertorn.presentationmvvm.utils.combineStates
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AlternativeMainViewModel : ViewModel() {

    private val firstState = MutableStateFlow<AlternativeMainCoeffUiState>(
        AlternativeMainCoeffUiState.Loading
    )
    private val secondState = MutableStateFlow<AlternativeMainCoeffUiState>(
        AlternativeMainCoeffUiState.Loading
    )

    init {
        launchFirstCoeff()
        launchSecondCoeff()
    }

    fun getFirstState(): StateFlow<AlternativeMainCoeffUiState> = firstState.asStateFlow()
    fun getSecondState(): StateFlow<AlternativeMainCoeffUiState> = secondState.asStateFlow()
    fun getResultState(): StateFlow<AlternativeMainResultUiState> = combineStates(
        firstState,
        secondState,
    ) { firstState, secondState ->
        when{
            firstState is AlternativeMainCoeffUiState.Loading -> AlternativeMainResultUiState.Loading
            secondState is AlternativeMainCoeffUiState.Loading -> AlternativeMainResultUiState.Loading
            else -> {
                firstState as AlternativeMainCoeffUiState.Content
                secondState as AlternativeMainCoeffUiState.Content
                AlternativeMainResultUiState.Content(
                    (firstState.value.toInt() + secondState.value.toInt()).toString()
                )
            }
        }
    }

    fun onFirstButtonIncreaseClick() {
        firstState.update { stateModel ->
            stateModel as AlternativeMainCoeffUiState.Content
            val updatedValue =
                if (stateModel.value.toInt() >= 25) stateModel.value.toInt() else stateModel.value.toInt() + 1
            AlternativeMainCoeffUiState.Content(
                value = updatedValue.toString(),
                increaseButtonColor = updatedValue.getIncreaseButtonColor(),
                decreaseButtonColor =updatedValue.getDecreaseButtonColor(),
                valueColor = updatedValue.getValueColor()
            )
        }
    }

    fun onFirstButtonDecreaseClick() {
        firstState.update { stateModel ->
            stateModel as AlternativeMainCoeffUiState.Content
            val updatedValue =
                if (stateModel.value.toInt() <= -5) stateModel.value.toInt() else stateModel.value.toInt() - 1
            AlternativeMainCoeffUiState.Content(
                value = updatedValue.toString(),
                increaseButtonColor = updatedValue.getIncreaseButtonColor(),
                decreaseButtonColor =updatedValue.getDecreaseButtonColor(),
                valueColor = updatedValue.getValueColor()
            )
        }
    }

    fun onSecondButtonIncreaseClick() {
        secondState.update { stateModel ->
            stateModel as AlternativeMainCoeffUiState.Content
            val updatedValue =
                if (stateModel.value.toInt() >= 25) stateModel.value.toInt() else stateModel.value.toInt() + 1
            AlternativeMainCoeffUiState.Content(
                value = updatedValue.toString(),
                increaseButtonColor = updatedValue.getIncreaseButtonColor(),
                decreaseButtonColor =updatedValue.getDecreaseButtonColor(),
                valueColor = updatedValue.getValueColor()
            )
        }
    }

    fun onSecondButtonDecreaseClick() {
        secondState.update { stateModel ->
            stateModel as AlternativeMainCoeffUiState.Content
            val updatedValue =
                if (stateModel.value.toInt() <= -5) stateModel.value.toInt() else stateModel.value.toInt() - 1
            AlternativeMainCoeffUiState.Content(
                value = updatedValue.toString(),
                increaseButtonColor = updatedValue.getIncreaseButtonColor(),
                decreaseButtonColor =updatedValue.getDecreaseButtonColor(),
                valueColor = updatedValue.getValueColor()
            )
        }
    }

    private fun launchFirstCoeff() {
        viewModelScope.launch {
            delay(3000)
            val resultFromNet = 7
            firstState.value = AlternativeMainCoeffUiState.Content(
                value = resultFromNet.toString(),
                increaseButtonColor = resultFromNet.getIncreaseButtonColor(),
                decreaseButtonColor =resultFromNet.getDecreaseButtonColor(),
                valueColor = resultFromNet.getValueColor()
            )
        }
    }

    private fun launchSecondCoeff() {
        viewModelScope.launch {
            delay(8000)
            val resultFromNet = -3
            secondState.value = AlternativeMainCoeffUiState.Content(
                value = resultFromNet.toString(),
                increaseButtonColor = resultFromNet.getIncreaseButtonColor(),
                decreaseButtonColor =resultFromNet.getDecreaseButtonColor(),
                valueColor = resultFromNet.getValueColor()
            )
        }
    }

    private fun Int.getValueColor(): Color = when (this) {
        -5 -> Color.Blue
        25 -> Color.Red
        else -> Color.Black
    }

    private fun Int.getIncreaseButtonColor(): Color = when {
        this >= 25 -> Color.DarkGray
        else -> Color.Blue
    }

    private fun Int.getDecreaseButtonColor(): Color = when {
        this <= -5 -> Color.DarkGray
        else -> Color.Blue
    }
}

