package org.ucb.appp1.earthquake.data.mapper

import org.ucb.appp1.earthquake.data.dto.EarthquakeFeatureDto
import org.ucb.appp1.earthquake.domain.model.Earthquake

class EarthquakeMapper {

    fun map(feature: EarthquakeFeatureDto): Earthquake {
        val coordinates = feature.geometry.coordinates

        return Earthquake(
            place = feature.properties.place ?: "Ubicación desconocida",
            magnitude = feature.properties.mag,
            time = feature.properties.time,
            url = feature.properties.url,
            longitude = coordinates[0],
            latitude = coordinates[1],
            depth = coordinates[2]
        )
    }
}