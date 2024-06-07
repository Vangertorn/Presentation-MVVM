package com.vangertorn.presentationmvvm

import androidx.compose.ui.graphics.Color

data class MainUiState(
    val firstValue: String,
    val firstValueColor: Color,
    val firstIncreaseButtonColor: Color,
    val firstDecreaseButtonColor: Color,
    val secondValue: String,
    val secondValueColor: Color,
    val secondIncreaseButtonColor: Color,
    val secondDecreaseButtonColor: Color,
    val resultValue: String,
)

