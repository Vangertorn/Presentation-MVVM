package com.vangertorn.presentationmvvm

import androidx.compose.ui.graphics.Color

fun MainStateModel.toMainUiStateMapper(): MainUiState {
    return when{
        firstValueLoading && secondValueLoading -> MainUiState.Loading.BothCoeffLoading
        secondValueLoading-> MainUiState.Loading.SecondCoeffLoading(
            firstValue = firstValue.toString(),
            firstValueColor = firstValue.getValueColor(),
            firstIncreaseButtonColor = firstValue.getIncreaseButtonColor(),
            firstDecreaseButtonColor = firstValue.getDecreaseButtonColor(),
        )
        firstValueLoading -> MainUiState.Loading.FirstCoeffLoading(
            secondValue = secondValue.toString(),
            secondValueColor = secondValue.getValueColor(),
            secondIncreaseButtonColor =secondValue.getIncreaseButtonColor(),
            secondDecreaseButtonColor = secondValue.getDecreaseButtonColor(),
        )
        else -> MainUiState.Content(
            firstValue = firstValue.toString(),
            firstValueColor = firstValue.getValueColor(),
            firstIncreaseButtonColor = firstValue.getIncreaseButtonColor(),
            firstDecreaseButtonColor = firstValue.getDecreaseButtonColor(),
            secondValue = secondValue.toString(),
            secondValueColor = secondValue.getValueColor(),
            secondIncreaseButtonColor =secondValue.getIncreaseButtonColor(),
            secondDecreaseButtonColor = secondValue.getDecreaseButtonColor(),
            resultValue = (firstValue + secondValue).toString()
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