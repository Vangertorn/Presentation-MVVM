package com.vangertorn.presentationmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import com.vangertorn.presentationmvvm.ui.theme.PresentationMVVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel = viewModel<MainViewModel>()
            val screenState: MainStateModel by viewModel.getState().collectAsStateWithLifecycle()
            PresentationMVVMTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        count = screenState.value,
                        modifier = Modifier.padding(innerPadding),
                        buttonIncreaseClick = viewModel::onButtonIncreaseClick,
                        buttonDecreaseClick = viewModel::onButtonDecreaseClick,
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(
    count: Int,
    modifier: Modifier,
    buttonIncreaseClick: () -> Unit,
    buttonDecreaseClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.LightGray),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(onClick = buttonIncreaseClick, modifier = modifier.padding(start = 32.dp, end = 8.dp)) {
            Text(text = "Increase")
        }
        Spacer(modifier = Modifier.width(16.dp))
        Button(onClick = buttonDecreaseClick, modifier = modifier.padding(start = 32.dp, end = 8.dp)) {
            Text(text = "Decrease")
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            modifier = modifier.padding(end = 32.dp, start = 8.dp),
            text = count.toString(),
            fontSize = 30.sp
        )
    }
}