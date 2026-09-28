package org.ucb.appp1.earthquake.data.service

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.ucb.appp1.earthquake.data.dto.EarthquakeResponseDto

class EarthquakeService {

    private val client = HttpClient()

    suspend fun getEarthquakes(): EarthquakeResponseDto {
        return client.get(
            "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&minmagnitude=5&limit=3"
        ).body()
    }
}