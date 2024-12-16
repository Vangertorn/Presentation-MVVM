package com.vangertorn.presentationmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vangertorn.presentationmvvm.alternative.AlternativeMainCoeffUiState
import com.vangertorn.presentationmvvm.alternative.AlternativeMainResultUiState
import com.vangertorn.presentationmvvm.alternative.AlternativeMainViewModel
import com.vangertorn.presentationmvvm.alternative.GreetingAlternative
import com.vangertorn.presentationmvvm.ui.theme.PresentationMVVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val viewModel = viewModel<AlternativeMainViewModel>()
            val firstState: AlternativeMainCoeffUiState by viewModel.getFirstState().collectAsStateWithLifecycle()
            val secondState: AlternativeMainCoeffUiState by viewModel.getSecondState()
                .collectAsStateWithLifecycle()
            val resultState: AlternativeMainResultUiState by viewModel.getResultState()
                .collectAsStateWithLifecycle()
            PresentationMVVMTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GreetingAlternative(
                        modifier = Modifier.padding(innerPadding),
                        firstButtonIncreaseClick = viewModel::onFirstButtonIncreaseClick,
                        firstButtonDecreaseClick = viewModel::onFirstButtonDecreaseClick,
                        secondButtonIncreaseClick = viewModel::onSecondButtonIncreaseClick,
                        secondButtonDecreaseClick = viewModel::onSecondButtonDecreaseClick,
                        firstState = firstState,
                        secondState = secondState,
                        resultState = resultState,
                        winningProcessClick = viewModel::onWinningProcessClick,
                        resetButton = viewModel::onRestoreValuesClick,
                    )
                }
            }
        }
        //        setContent {
        //            val viewModel = viewModel<MainViewModel>()
        //            val screenState: MainUiState by viewModel.getState().collectAsStateWithLifecycle()
        //            PresentationMVVMTheme {
        //                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        //                    when (val state = screenState) {
        //                        is MainUiState.Content -> state.GreetingContent(
        //                            modifier = Modifier.padding(innerPadding),
        //                            firstButtonIncreaseClick = viewModel::onFirstButtonIncreaseClick,
        //                            firstButtonDecreaseClick = viewModel::onFirstButtonDecreaseClick,
        //                            secondButtonIncreaseClick = viewModel::onSecondButtonIncreaseClick,
        //                            secondButtonDecreaseClick = viewModel::onSecondButtonDecreaseClick,
        //                            winningProcessClick = viewModel::onWinningProcessClick,
        //                        )
        //                        is MainUiState.Loading.BothCoeffLoading ->
        //                            state.BothCoeffLoading(modifier = Modifier.padding(innerPadding))
        //                        is MainUiState.Loading.FirstCoeffLoading ->
        //                            state.GreetingFirstCoeffLoading(
        //                                modifier = Modifier.padding(innerPadding),
        //                                secondButtonIncreaseClick = viewModel::onSecondButtonIncreaseClick,
        //                                secondButtonDecreaseClick = viewModel::onSecondButtonDecreaseClick,
        //                            )
        //                        is MainUiState.Loading.SecondCoeffLoading ->
        //                            state.SecondCoeffLoading(
        //                                modifier = Modifier.padding(innerPadding),
        //                                firstButtonIncreaseClick = viewModel::onFirstButtonIncreaseClick,
        //                                firstButtonDecreaseClick = viewModel::onFirstButtonDecreaseClick,
        //                            )
        //                        is MainUiState.Error ->
        //                            state.GreetingError(
        //                                modifier = Modifier.padding(innerPadding),
        //                                firstButtonIncreaseClick = viewModel::onFirstButtonIncreaseClick,
        //                                firstButtonDecreaseClick = viewModel::onFirstButtonDecreaseClick,
        //                                secondButtonIncreaseClick = viewModel::onSecondButtonIncreaseClick,
        //                                secondButtonDecreaseClick = viewModel::onSecondButtonDecreaseClick,
        //                                resetButton = viewModel::onRestoreValuesClick,
        //                            )
        //                    }
        //                }
        //            }
        //        }
    }
}