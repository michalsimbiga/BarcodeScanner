package com.msimbiga.barcodescanner.feature.scan

import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.core.content.ContextCompat

fun checkAndRequestCameraPermission(
    context: Context,
    permission: String,
    launcher: ManagedActivityResultLauncher<String, Boolean>
) {
    val permissionCheckResult = ContextCompat.checkSelfPermission(context, permission)

    if (permissionCheckResult == PackageManager.PERMISSION_GRANTED) {

    } else {
        launcher.launch(permission)
    }
}