package com.vangertorn.presentationmvvm.composabels

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vangertorn.presentationmvvm.MainUiState

@Composable
fun MainUiState.Content.GreetingContent(
    modifier: Modifier,
    firstButtonIncreaseClick: () -> Unit,
    firstButtonDecreaseClick: () -> Unit,
    secondButtonIncreaseClick: () -> Unit,
    secondButtonDecreaseClick: () -> Unit,
    winningProcessClick: () -> Unit,
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
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = winningProcessClick,
                enabled = resultButtonEnable,
                modifier = modifier.padding(start = 32.dp, end = 8.dp),
            ) {
                Text(text = "Get winning")
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                modifier = modifier.padding(end = 32.dp, start = 8.dp),
                text = resultValue,
                fontSize = 40.sp,
            )
        }
    }
}