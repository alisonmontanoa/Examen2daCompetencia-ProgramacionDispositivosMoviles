package org.ucb.appp1.earthquake.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class EarthquakeGeometryDto(
    val coordinates: List<Double>
)