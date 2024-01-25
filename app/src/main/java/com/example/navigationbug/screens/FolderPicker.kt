package com.example.navigationbug.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable

@Composable
fun launchFolderPicker(
    onFolderSelected: (Uri) -> Unit,
): ActivityResultLauncher<Uri?> =
    rememberLauncherForActivityResult(ActivityResultContracts.OpenDocumentTree()) { directoryUri ->
        directoryUri?.let {
            onFolderSelected(it)
        }
    }
