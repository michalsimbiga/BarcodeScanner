package com.msimbiga.barcodescanner.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.msimbiga.barcodescanner.feature.details.DetailsScreen
import com.msimbiga.barcodescanner.feature.history.HistoryScreen
import com.msimbiga.barcodescanner.feature.scan.ScanScreen

@Composable
fun MainNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "scan") {
        composable("scan") { ScanScreen() }
        composable("details") { DetailsScreen() }
        composable("history") { HistoryScreen() }
    }
}
