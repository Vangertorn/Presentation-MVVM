package com.vangertorn.presentationmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vangertorn.presentationmvvm.alternative.AlternativeMainCoeffUiStateModel
import com.vangertorn.presentationmvvm.alternative.AlternativeMainResultUiStateModel
import com.vangertorn.presentationmvvm.alternative.AlternativeMainViewModel
import com.vangertorn.presentationmvvm.ui.theme.PresentationMVVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//                setContent {
//                    val viewModel = viewModel<AlternativeMainViewModel>()
//                    val firstState: AlternativeMainCoeffUiStateModel by viewModel.getFirstState().collectAsStateWithLifecycle()
//                    val secondState: AlternativeMainCoeffUiStateModel by viewModel.getSecondState().collectAsStateWithLifecycle()
//                    val resultState: AlternativeMainResultUiStateModel by viewModel.getResultState().collectAsStateWithLifecycle()
//                    PresentationMVVMTheme {
//                        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                            GreetingAlternative(
//                                modifier = Modifier.padding(innerPadding),
//                                firstButtonIncreaseClick = viewModel::onFirstButtonIncreaseClick,
//                                firstButtonDecreaseClick = viewModel::onFirstButtonDecreaseClick,
//                                secondButtonIncreaseClick = viewModel::onSecondButtonIncreaseClick,
//                                secondButtonDecreaseClick = viewModel::onSecondButtonDecreaseClick,
//                                firstState = firstState,
//                                secondState =secondState,
//                                resultState =resultState,
//
//                                )
//                        }
//                    }
//                }
        setContent {
            val viewModel = viewModel<MainViewModel>()
            val screenState: MainUiState by viewModel.getState().collectAsStateWithLifecycle()
            PresentationMVVMTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    screenState.Greeting(
                        modifier = Modifier.padding(innerPadding),
                        firstButtonIncreaseClick = viewModel::onFirstButtonIncreaseClick,
                        firstButtonDecreaseClick = viewModel::onFirstButtonDecreaseClick,
                        secondButtonIncreaseClick = viewModel::onSecondButtonIncreaseClick,
                        secondButtonDecreaseClick = viewModel::onSecondButtonDecreaseClick,
                    )
                }
            }
        }
    }
}

@Composable
fun MainUiState.Greeting(
    modifier: Modifier,
    firstButtonIncreaseClick: () -> Unit,
    firstButtonDecreaseClick: () -> Unit,
    secondButtonIncreaseClick: () -> Unit,
    secondButtonDecreaseClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = firstButtonIncreaseClick,
                colors = ButtonDefaults.buttonColors(containerColor = firstIncreaseButtonColor),
                modifier = modifier.padding(start = 32.dp, end = 8.dp),
            ) {
                Text(text = "Increase")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = firstButtonDecreaseClick,
                colors = ButtonDefaults.buttonColors(containerColor = firstDecreaseButtonColor),
                modifier = modifier.padding(start = 32.dp, end = 8.dp),
            ) {
                Text(text = "Decrease")
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                modifier = modifier.padding(end = 32.dp, start = 8.dp),
                text = firstValue,
                fontSize = 30.sp,
                color = firstValueColor,
            )
        }
        Spacer(modifier = Modifier.width(32.dp))
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = secondButtonIncreaseClick,
                colors = ButtonDefaults.buttonColors(containerColor = secondIncreaseButtonColor),
                modifier = modifier.padding(start = 32.dp, end = 8.dp),
            ) {
                Text(text = "Increase")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = secondButtonDecreaseClick,
                colors = ButtonDefaults.buttonColors(containerColor = secondDecreaseButtonColor),
                modifier = modifier.padding(start = 32.dp, end = 8.dp),
            ) {
                Text(text = "Decrease")
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                modifier = modifier.padding(end = 32.dp, start = 8.dp),
                text = secondValue,
                fontSize = 30.sp,
                color = secondValueColor,
            )
        }
        Text(
            modifier = modifier.padding(end = 32.dp, start = 32.dp),
            text = resultValue,
            fontSize = 40.sp
        )
    }
}

@Composable
fun GreetingAlternative(
    firstState: AlternativeMainCoeffUiStateModel,
    secondState: AlternativeMainCoeffUiStateModel,
    resultState: AlternativeMainResultUiStateModel,
    modifier: Modifier,
    firstButtonIncreaseClick: () -> Unit,
    firstButtonDecreaseClick: () -> Unit,
    secondButtonIncreaseClick: () -> Unit,
    secondButtonDecreaseClick: () -> Unit,
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = firstButtonIncreaseClick,
                colors = ButtonDefaults.buttonColors(containerColor = firstState.increaseButtonColor),
                modifier = modifier.padding(start = 32.dp, end = 8.dp),
            ) {
                Text(text = "Increase")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = firstButtonDecreaseClick,
                colors = ButtonDefaults.buttonColors(containerColor = firstState.decreaseButtonColor),
                modifier = modifier.padding(start = 32.dp, end = 8.dp),
            ) {
                Text(text = "Decrease")
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                modifier = modifier.padding(end = 32.dp, start = 8.dp),
                text = firstState.value,
                fontSize = 30.sp,
                color = firstState.valueColor,
            )
        }
        Spacer(modifier = Modifier.width(32.dp))
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = secondButtonIncreaseClick,
                colors = ButtonDefaults.buttonColors(containerColor = secondState.increaseButtonColor),
                modifier = modifier.padding(start = 32.dp, end = 8.dp),
            ) {
                Text(text = "Increase")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = secondButtonDecreaseClick,
                colors = ButtonDefaults.buttonColors(containerColor =  secondState.decreaseButtonColor),
                modifier = modifier.padding(start = 32.dp, end = 8.dp),
            ) {
                Text(text = "Decrease")
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                modifier = modifier.padding(end = 32.dp, start = 8.dp),
                text =  secondState.value,
                fontSize = 30.sp,
                color =  secondState.valueColor,
            )
        }
        Text(
            modifier = modifier.padding(end = 32.dp, start = 32.dp),
            text = resultState.value,
            fontSize = 40.sp
        )
    }
}