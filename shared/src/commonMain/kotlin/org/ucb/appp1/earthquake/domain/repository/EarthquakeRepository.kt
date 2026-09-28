package org.ucb.appp1.earthquake.domain.repository

import org.ucb.appp1.earthquake.domain.model.Earthquake

interface EarthquakeRepository {

    suspend fun getEarthquakes(): List<Earthquake>
}