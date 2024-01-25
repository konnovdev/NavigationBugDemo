package com.example.navigationbug.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import timber.log.Timber

@Composable
fun ThirdScreen() {
    val folderPicker = launchFolderPicker {
        Timber.d("Folder selected: $it")
    }
    Column(Modifier.padding(16.dp)) {
        Text("Third screen")
        Button(
            onClick = {
                folderPicker.launch(null)
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Open folder picker")
        }
    }
}
