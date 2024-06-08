package com.vangertorn.presentationmvvm.alternative

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GreetingAlternative(
    firstState: AlternativeMainCoeffUiState,
    secondState: AlternativeMainCoeffUiState,
    resultState: AlternativeMainResultUiState,
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
                colors = ButtonDefaults.buttonColors(
                    containerColor =
                    when (firstState) {
                        is AlternativeMainCoeffUiState.Content -> firstState.increaseButtonColor
                        AlternativeMainCoeffUiState.Loading -> Color.DarkGray
                    }
                ),
                modifier = modifier.padding(start = 32.dp, end = 8.dp),
            ) {
                Text(text = "Increase")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = firstButtonDecreaseClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = when (firstState) {
                        is AlternativeMainCoeffUiState.Content -> firstState.decreaseButtonColor
                        AlternativeMainCoeffUiState.Loading -> Color.DarkGray
                    }
                ),
                modifier = modifier.padding(start = 32.dp, end = 8.dp),
            ) {
                Text(text = "Decrease")
            }
            Spacer(modifier = Modifier.weight(1f))
            when (firstState) {
                is AlternativeMainCoeffUiState.Content -> Text(
                    modifier = modifier.padding(end = 32.dp, start = 8.dp),
                    text = firstState.value,
                    fontSize = 30.sp,
                    color = firstState.valueColor,
                )
                AlternativeMainCoeffUiState.Loading ->
                    CircularProgressIndicator(
                        modifier = Modifier
                            .width(72.dp)
                            .padding(end = 32.dp, start = 8.dp),
                        color = MaterialTheme.colorScheme.secondary,
                        trackColor = MaterialTheme.colorScheme.surfaceVariant
                    )
            }

        }
        Spacer(modifier = Modifier.width(32.dp))
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = secondButtonIncreaseClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = when (secondState) {
                        is AlternativeMainCoeffUiState.Content -> secondState.increaseButtonColor
                        AlternativeMainCoeffUiState.Loading -> Color.DarkGray
                    }
                ),
                modifier = modifier.padding(start = 32.dp, end = 8.dp),
            ) {
                Text(text = "Increase")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = secondButtonDecreaseClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = when (secondState) {
                        is AlternativeMainCoeffUiState.Content -> secondState.decreaseButtonColor
                        AlternativeMainCoeffUiState.Loading -> Color.DarkGray
                    }
                ),
                modifier = modifier.padding(start = 32.dp, end = 8.dp),
            ) {
                Text(text = "Decrease")
            }
            Spacer(modifier = Modifier.weight(1f))
            when (secondState) {
                is AlternativeMainCoeffUiState.Content -> Text(
                    modifier = modifier.padding(end = 32.dp, start = 8.dp),
                    text = secondState.value,
                    fontSize = 30.sp,
                    color = secondState.valueColor,
                )
                AlternativeMainCoeffUiState.Loading ->
                    CircularProgressIndicator(
                        modifier = Modifier
                            .width(72.dp)
                            .padding(end = 32.dp, start = 8.dp),
                        color = MaterialTheme.colorScheme.secondary,
                        trackColor = MaterialTheme.colorScheme.surfaceVariant
                    )
            }
        }
        when (resultState) {
            is AlternativeMainResultUiState.Content -> Text(
                modifier = modifier.padding(end = 32.dp, start = 32.dp),
                text = resultState.value,
                fontSize = 40.sp
            )
            AlternativeMainResultUiState.Loading ->
                CircularProgressIndicator(
                    modifier = Modifier
                        .width(72.dp)
                        .padding(end = 32.dp, start = 8.dp),
                    color = MaterialTheme.colorScheme.secondary,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant
                )
        }

    }
}