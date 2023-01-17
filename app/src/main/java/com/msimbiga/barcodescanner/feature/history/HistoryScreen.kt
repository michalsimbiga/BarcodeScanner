package com.msimbiga.barcodescanner.feature.history

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HistoryScreen(viewModel: HistoryScreenViewModel = hiltViewModel()) {
    Text(text = "History Screen")
}