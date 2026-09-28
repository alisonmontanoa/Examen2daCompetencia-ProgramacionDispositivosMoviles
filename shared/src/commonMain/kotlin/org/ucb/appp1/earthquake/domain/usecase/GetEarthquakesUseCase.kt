package org.ucb.appp1.earthquake.domain.usecase

import org.ucb.appp1.earthquake.domain.model.Earthquake
import org.ucb.appp1.earthquake.domain.repository.EarthquakeRepository

class GetEarthquakesUseCase(
    private val repository: EarthquakeRepository
) {

    suspend operator fun invoke(): List<Earthquake> {
        return repository.getEarthquakes()
    }
}