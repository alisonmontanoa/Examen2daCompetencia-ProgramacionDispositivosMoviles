package org.ucb.appp1.earthquake.presentation.viewmodel

sealed interface EarthquakeEvent {
    data object LoadEarthquakes : EarthquakeEvent
}