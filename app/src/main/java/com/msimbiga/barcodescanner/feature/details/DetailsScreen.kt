package com.msimbiga.barcodescanner.feature.details

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun DetailsScreen(viewModel: DetailsScreenViewModel = hiltViewModel()) {
    Text(text = "Details screen")
}