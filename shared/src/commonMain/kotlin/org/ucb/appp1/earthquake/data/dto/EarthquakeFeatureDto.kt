package org.ucb.appp1.earthquake.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class EarthquakeFeatureDto(
    val properties: EarthquakePropertiesDto,
    val geometry: EarthquakeGeometryDto
)