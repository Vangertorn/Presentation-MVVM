package com.vangertorn.presentationmvvm.alternative

import androidx.compose.ui.graphics.Color

sealed interface AlternativeMainCoeffUiState {
    data class Content(
        val value: String,
        val valueColor: Color,
        val increaseButtonColor: Color,
        val decreaseButtonColor: Color,
    ) : AlternativeMainCoeffUiState

    object Error: AlternativeMainCoeffUiState

    object Winner: AlternativeMainCoeffUiState

    object Loading : AlternativeMainCoeffUiState
}