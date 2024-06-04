package com.vangertorn.presentationmvvm

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MainViewModel: ViewModel() {

    private val state = MutableStateFlow(MainStateModel(0))

    fun getState(): StateFlow<MainStateModel> = state

    fun onButtonIncreaseClick() {
        state.update { stateModel ->
            MainStateModel(stateModel.value + 1)
        }
    }

    fun onButtonDecreaseClick() {
        state.update { stateModel ->
            MainStateModel(stateModel.value -1)
        }
    }
}