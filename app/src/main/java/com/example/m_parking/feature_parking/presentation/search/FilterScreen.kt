package com.example.m_parking.feature_parking.presentation.search

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun FilterScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
        contentAlignment = Alignment.Center,
        propagateMinConstraints = true
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(.6f)
                .align(Alignment.BottomCenter)
                .background(
                    if (isSystemInDarkTheme())
                        Color.Black.copy(.24f) else
                        Color.White.copy(.24f),
                    shape = MaterialTheme.shapes.extraLarge
                )
        ) {

        }
    }
}

@Composable
fun FilterItems(
    text: String,
    onClicked: ()-> Unit
) {
    Column(

    ) {

    }
}