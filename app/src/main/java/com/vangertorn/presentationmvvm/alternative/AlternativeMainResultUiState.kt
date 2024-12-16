package com.vangertorn.presentationmvvm.alternative

sealed interface AlternativeMainResultUiState {

    data class Content(
        val value: String,
        val buttonEnable: Boolean,
    ) : AlternativeMainResultUiState

    object Winner : AlternativeMainResultUiState

    object Loading : AlternativeMainResultUiState

    object Error : AlternativeMainResultUiState
}