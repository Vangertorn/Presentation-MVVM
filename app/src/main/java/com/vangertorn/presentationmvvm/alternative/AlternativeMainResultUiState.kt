package com.vangertorn.presentationmvvm.alternative

sealed interface AlternativeMainResultUiState {

    data class Content(val value: String) : AlternativeMainResultUiState

    object Loading : AlternativeMainResultUiState
}



