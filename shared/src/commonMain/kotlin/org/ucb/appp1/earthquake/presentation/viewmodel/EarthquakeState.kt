package org.ucb.appp1.earthquake.presentation.viewmodel

import org.ucb.appp1.earthquake.domain.model.Earthquake

data class EarthquakeState(
    val isLoading: Boolean = false,
    val earthquakes: List<Earthquake> = emptyList(),
    val error: String? = null
)