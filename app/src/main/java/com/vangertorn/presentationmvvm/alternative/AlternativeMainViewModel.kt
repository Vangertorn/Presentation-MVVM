package com.vangertorn.presentationmvvm.alternative

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.vangertorn.presentationmvvm.utils.combineStates
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AlternativeMainViewModel : ViewModel() {

    private val firstState = MutableStateFlow(
        AlternativeMainCoeffUiStateModel(
            value = "0",
            valueColor = Color.Black,
            increaseButtonColor = Color.Blue,
            decreaseButtonColor = Color.Blue,
        )
    )
    private val secondState = MutableStateFlow(
        AlternativeMainCoeffUiStateModel(
            value = "0",
            valueColor = Color.Black,
            increaseButtonColor = Color.Blue,
            decreaseButtonColor = Color.Blue,
        )
    )

    fun getFirstState(): StateFlow<AlternativeMainCoeffUiStateModel> = firstState.asStateFlow()
    fun getSecondState(): StateFlow<AlternativeMainCoeffUiStateModel> = secondState.asStateFlow()
    fun getResultState(): StateFlow<AlternativeMainResultUiStateModel> = combineStates(
        firstState,
        secondState,
    ) { firstState, secondState ->
        AlternativeMainResultUiStateModel((firstState.value.toInt() + secondState.value.toInt()).toString())
    }

    fun onFirstButtonIncreaseClick() {
        firstState.update { stateModel ->
            val updatedValue =
                if (stateModel.value.toInt() >= 25) stateModel.value.toInt() else stateModel.value.toInt() + 1
            AlternativeMainCoeffUiStateModel(
                value = updatedValue.toString(),
                increaseButtonColor = updatedValue.getIncreaseButtonColor(),
                decreaseButtonColor =updatedValue.getDecreaseButtonColor(),
                valueColor = updatedValue.getValueColor()
            )
        }
    }

    fun onFirstButtonDecreaseClick() {
        firstState.update { stateModel ->
            val updatedValue =
                if (stateModel.value.toInt() <= -5) stateModel.value.toInt() else stateModel.value.toInt() - 1
            AlternativeMainCoeffUiStateModel(
                value = updatedValue.toString(),
                increaseButtonColor = updatedValue.getIncreaseButtonColor(),
                decreaseButtonColor =updatedValue.getDecreaseButtonColor(),
                valueColor = updatedValue.getValueColor()
            )
        }
    }

    fun onSecondButtonIncreaseClick() {
        secondState.update { stateModel ->
            val updatedValue =
                if (stateModel.value.toInt() >= 25) stateModel.value.toInt() else stateModel.value.toInt() + 1
            AlternativeMainCoeffUiStateModel(
                value = updatedValue.toString(),
                increaseButtonColor = updatedValue.getIncreaseButtonColor(),
                decreaseButtonColor =updatedValue.getDecreaseButtonColor(),
                valueColor = updatedValue.getValueColor()
            )
        }
    }

    fun onSecondButtonDecreaseClick() {
        secondState.update { stateModel ->
            val updatedValue =
                if (stateModel.value.toInt() <= -5) stateModel.value.toInt() else stateModel.value.toInt() - 1
            AlternativeMainCoeffUiStateModel(
                value = updatedValue.toString(),
                increaseButtonColor = updatedValue.getIncreaseButtonColor(),
                decreaseButtonColor =updatedValue.getDecreaseButtonColor(),
                valueColor = updatedValue.getValueColor()
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

