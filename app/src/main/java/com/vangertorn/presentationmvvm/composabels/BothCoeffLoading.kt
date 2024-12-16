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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vangertorn.presentationmvvm.MainUiState

@Composable
fun MainUiState.Loading.BothCoeffLoading.BothCoeffLoading(
    modifier: Modifier,
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
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                modifier = modifier.padding(start = 32.dp, end = 8.dp),
            ) {
                Text(text = "Increase")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                modifier = modifier.padding(start = 32.dp, end = 8.dp),
            ) {
                Text(text = "Decrease")
            }
            Spacer(modifier = Modifier.weight(1f))
            CircularProgressIndicator(
                modifier = Modifier.width(72.dp)
                    .padding(end = 32.dp, start = 8.dp),
                color = MaterialTheme.colorScheme.secondary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant
            )
        }
        Spacer(modifier = Modifier.width(32.dp))
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                modifier = modifier.padding(start = 32.dp, end = 8.dp),
            ) {
                Text(text = "Increase")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                modifier = modifier.padding(start = 32.dp, end = 8.dp),
            ) {
                Text(text = "Decrease")
            }
            Spacer(modifier = Modifier.weight(1f))
            CircularProgressIndicator(
                modifier = Modifier.width(72.dp)
                    .padding(end = 32.dp, start = 8.dp),
                color = MaterialTheme.colorScheme.secondary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant
            )
        }
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if(isWinningTextVisible){
                Text(
                    modifier = modifier.padding(end = 32.dp, start = 8.dp),
                    text = "You are winner!!!",
                    fontSize = 40.sp,
                )
            }else{
                Button(
                    onClick = {},
                    enabled = false,
                    modifier = modifier.padding(start = 32.dp, end = 8.dp),
                ) {
                    Text(text = "Get winning")
                }
                Spacer(modifier = Modifier.weight(1f))
                CircularProgressIndicator(
                    modifier = Modifier.width(72.dp)
                        .padding(end = 32.dp, start = 8.dp),
                    color = MaterialTheme.colorScheme.secondary,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant
                )
            }
        }
    }
}