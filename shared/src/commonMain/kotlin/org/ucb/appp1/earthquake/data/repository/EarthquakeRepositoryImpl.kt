package org.ucb.appp1.earthquake.data.repository

import org.ucb.appp1.earthquake.data.datasource.EarthquakeRemoteDataSource
import org.ucb.appp1.earthquake.data.mapper.EarthquakeMapper
import org.ucb.appp1.earthquake.domain.model.Earthquake
import org.ucb.appp1.earthquake.domain.repository.EarthquakeRepository

class EarthquakeRepositoryImpl(
    private val remoteDataSource: EarthquakeRemoteDataSource,
    private val mapper: EarthquakeMapper
) : EarthquakeRepository {

    override suspend fun getEarthquakes(): List<Earthquake> {
        val response = remoteDataSource.getEarthquakes()

        return response.features.map { feature ->
            mapper.map(feature)
        }
    }
}