package org.ucb.appp1

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.ucb.appp1.earthquake.presentation.screen.EarthquakeScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        EarthquakeScreen()
    }
}