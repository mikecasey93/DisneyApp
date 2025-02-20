package com.example.disneyapp.common.state

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun <T : Any> CommonScreen(
    state: UiState<T>,
    onSuccess: @Composable (T) -> Unit
) {
    when (state) {
        is UiState.Loading -> {
            Loading()
        }

        is UiState.Error -> {
            ErrorMessage(state.errorMessage)
        }

        is UiState.Success -> {
            onSuccess(state.data)
        }
    }
}

@Composable
fun ErrorMessage(errorMsg: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Snackbar {
            Text(text = errorMsg)
        }
    }
}

@Composable
fun Loading() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
    }
}