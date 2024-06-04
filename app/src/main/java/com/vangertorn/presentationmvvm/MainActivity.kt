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
import com.vangertorn.presentationmvvm.alternative.AlternativeMainStateModel
import com.vangertorn.presentationmvvm.alternative.AlternativeMainViewModel
import com.vangertorn.presentationmvvm.ui.theme.PresentationMVVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//        setContent {
//            val viewModel = viewModel<AlternativeMainViewModel>()
//            val firstState: AlternativeMainStateModel by viewModel.getFirstState().collectAsStateWithLifecycle()
//            val secondState: AlternativeMainStateModel by viewModel.getSecondState().collectAsStateWithLifecycle()
//            val resultState: AlternativeMainStateModel by viewModel.getResultState().collectAsStateWithLifecycle()
//            PresentationMVVMTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        firstCount = firstState.value,
//                        secondCount = secondState.value,
//                        result = resultState.value,
//                        modifier = Modifier.padding(innerPadding),
//                        firstButtonIncreaseClick = viewModel::onFirstButtonIncreaseClick,
//                        firstButtonDecreaseClick = viewModel::onFirstButtonDecreaseClick,
//                        secondButtonIncreaseClick = viewModel::onSecondButtonIncreaseClick,
//                        secondButtonDecreaseClick = viewModel::onSecondButtonDecreaseClick,
//                    )
//                }
//            }
//        }
        setContent {
            val viewModel = viewModel<MainViewModel>()
            val screenState: MainStateModel by viewModel.getState().collectAsStateWithLifecycle()
            PresentationMVVMTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        firstCount = screenState.firstValue,
                        secondCount = screenState.secondValue,
                        result = screenState.firstValue + screenState.secondValue,
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
fun Greeting(
    firstCount: Int,
    secondCount: Int,
    result: Int,
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
            Button(onClick = firstButtonIncreaseClick, modifier = modifier.padding(start = 32.dp, end = 8.dp)) {
                Text(text = "Increase")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = firstButtonDecreaseClick, modifier = modifier.padding(start = 32.dp, end = 8.dp)) {
                Text(text = "Decrease")
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                modifier = modifier.padding(end = 32.dp, start = 8.dp),
                text = firstCount.toString(),
                fontSize = 30.sp
            )
        }
        Spacer(modifier = Modifier.width(32.dp))
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = secondButtonIncreaseClick, modifier = modifier.padding(start = 32.dp, end = 8.dp)) {
                Text(text = "Increase")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = secondButtonDecreaseClick, modifier = modifier.padding(start = 32.dp, end = 8.dp)) {
                Text(text = "Decrease")
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                modifier = modifier.padding(end = 32.dp, start = 8.dp),
                text = secondCount.toString(),
                fontSize = 30.sp
            )
        }
        Text(
            modifier = modifier.padding(end = 32.dp, start = 32.dp),
            text = result.toString(),
            fontSize = 40.sp
        )
    }
}