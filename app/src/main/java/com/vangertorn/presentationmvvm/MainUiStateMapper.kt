package com.vangertorn.presentationmvvm

import androidx.compose.ui.graphics.Color

fun MainStateModel.toMainUiStateMapper(): MainUiState {
    return MainUiState(
        firstValue = firstValue.toString(),
        firstValueColor = when (firstValue) {
            -5 -> Color.Blue
            25 -> Color.Red
            else -> Color.Black
        },
        firstIncreaseButtonColor = when {
            firstValue >= 25 -> Color.DarkGray
            else -> Color.Blue
        },
        firstDecreaseButtonColor = when {
            firstValue <= -5 -> Color.DarkGray
            else -> Color.Blue
        },
        secondValue = secondValue.toString(),
        secondValueColor = when (secondValue) {
            -5 -> Color.Blue
            25 -> Color.Red
            else -> Color.Black
        },
        secondIncreaseButtonColor = when {
            secondValue >= 25 -> Color.DarkGray
            else -> Color.Blue
        },
        secondDecreaseButtonColor = when {
            secondValue <= -5 -> Color.DarkGray
            else -> Color.Blue
        },
        resultValue = (firstValue + secondValue).toString()
    )
}