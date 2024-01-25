package com.example.navigationbug.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SecondScreen(nextScreenClicked: () -> Unit) {
    Column(Modifier.padding(16.dp)) {
        Text("Second screen")
        Button(
            onClick = nextScreenClicked,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Go to next screen")
        }
    }
}
