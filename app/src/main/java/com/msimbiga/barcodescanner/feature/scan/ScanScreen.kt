package com.msimbiga.barcodescanner.feature.scan


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPermissionsApi::class)
@Composable
fun ScanScreen(viewModel: ScanScreenViewModel = hiltViewModel()) {

    val cameraPermissionState =
        rememberPermissionState(android.Manifest.permission.CAMERA)

//    LaunchedEffect(cameraPermissionState) {
//        cameraPermissionState.launchPermissionRequest()
//    }

    SideEffect {
        cameraPermissionState.launchPermissionRequest()
    }

    Scaffold {
        when {
            cameraPermissionState.status.isGranted -> ScanScreenContent(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            )
            !cameraPermissionState.status.isGranted ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "No camera permission")
                }
        }
    }
}

@Composable
private fun ScanScreenContent(modifier: Modifier) {
    Box(modifier = modifier) {
        CameraPreview(modifier = Modifier.matchParentSize())
        ScannerOverlay(modifier = Modifier.matchParentSize())
    }
}

@Composable
private fun ScannerOverlay(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier) {
        val rectSize = size.width * 0.6f
        val topLeft = Offset(center.x - rectSize / 2f, center.y - rectSize / 2f)

        drawRect(
            color = Color.Black.copy(alpha = 0.5f),
            topLeft = Offset(0f, 0f),
            size = size
        )
        drawRoundRect(
            color = Color.White,
            topLeft = topLeft,
            size = Size(rectSize, rectSize),
            blendMode = BlendMode.Clear
        )
    }
}