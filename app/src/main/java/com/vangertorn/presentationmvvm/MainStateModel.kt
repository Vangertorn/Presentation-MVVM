package com.vangertorn.presentationmvvm

data class MainStateModel(
    val firstValue: Int,
    val firstValueLoading: Boolean,
    val secondValue: Int,
    val secondValueLoading: Boolean,
    val isWinningProcess: Boolean,
    val winningResult: WinningResultType?,
)

enum class WinningResultType{
    ERROR,
    SUCCESS
}