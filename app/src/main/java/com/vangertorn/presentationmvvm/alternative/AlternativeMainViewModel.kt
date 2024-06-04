package com.vangertorn.presentationmvvm.alternative

import androidx.lifecycle.ViewModel
import com.vangertorn.presentationmvvm.utils.combineStates
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class AlternativeMainViewModel : ViewModel() {

    private val firstState = MutableStateFlow(AlternativeMainStateModel(0))
    private val secondState = MutableStateFlow(AlternativeMainStateModel(0))

    fun getFirstState(): StateFlow<AlternativeMainStateModel> = firstState
    fun getSecondState(): StateFlow<AlternativeMainStateModel> = secondState
    fun getResultState(): StateFlow<AlternativeMainStateModel> = combineStates(
        firstState,
        secondState,
    ) { firstState, secondState ->
        AlternativeMainStateModel(firstState.value + secondState.value)
    }

    fun onFirstButtonIncreaseClick() {
        firstState.update { stateModel ->
            AlternativeMainStateModel(stateModel.value + 1)
        }
    }

    fun onFirstButtonDecreaseClick() {
        firstState.update { stateModel ->
            AlternativeMainStateModel(stateModel.value - 1)
        }
    }

    fun onSecondButtonIncreaseClick() {
        secondState.update { stateModel ->
            AlternativeMainStateModel(stateModel.value + 1)
        }
    }

    fun onSecondButtonDecreaseClick() {
        secondState.update { stateModel ->
            AlternativeMainStateModel(stateModel.value - 1)
        }
    }
}

