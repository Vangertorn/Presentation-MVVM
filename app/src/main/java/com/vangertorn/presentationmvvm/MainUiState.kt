package com.vangertorn.presentationmvvm

import androidx.compose.ui.graphics.Color

sealed interface MainUiState {

    data class Content(
        val firstValue: String,
        val firstValueColor: Color,
        val firstIncreaseButtonColor: Color,
        val firstDecreaseButtonColor: Color,
        val secondValue: String,
        val secondValueColor: Color,
        val secondIncreaseButtonColor: Color,
        val secondDecreaseButtonColor: Color,
        val resultValue: String,
    ) : MainUiState

    sealed interface Loading : MainUiState {
        data class FirstCoeffLoading(
            val secondValue: String,
            val secondValueColor: Color,
            val secondIncreaseButtonColor: Color,
            val secondDecreaseButtonColor: Color,
        ) : Loading

        data class SecondCoeffLoading(
            val firstValue: String,
            val firstValueColor: Color,
            val firstIncreaseButtonColor: Color,
            val firstDecreaseButtonColor: Color,
        ) : Loading

        object BothCoeffLoading : Loading
    }
}

