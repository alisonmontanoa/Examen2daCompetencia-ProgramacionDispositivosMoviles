package org.ucb.appp1.earthquake.data.datasource

import org.ucb.appp1.earthquake.data.dto.EarthquakeResponseDto
import org.ucb.appp1.earthquake.data.service.EarthquakeService

class EarthquakeRemoteDataSource(
    private val service: EarthquakeService
) {

    suspend fun getEarthquakes(): EarthquakeResponseDto {
        return service.getEarthquakes()
    }
}