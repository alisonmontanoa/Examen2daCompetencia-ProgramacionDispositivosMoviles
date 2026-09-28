package org.ucb.appp1.earthquake.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.ucb.appp1.earthquake.domain.usecase.GetEarthquakesUseCase

class EarthquakeViewModel(
    private val getEarthquakesUseCase: GetEarthquakesUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(EarthquakeState())
    val state: StateFlow<EarthquakeState> = _state.asStateFlow()

    fun onEvent(event: EarthquakeEvent) {
        when (event) {
            EarthquakeEvent.LoadEarthquakes -> loadEarthquakes()
        }
    }

    private fun loadEarthquakes() {
        viewModelScope.launch {
            _state.value = EarthquakeState(isLoading = true)

            try {
                val earthquakes = getEarthquakesUseCase()

                _state.value = EarthquakeState(
                    earthquakes = earthquakes
                )
            } catch (e: Exception) {
                _state.value = EarthquakeState(
                    error = "Error al obtener los terremotos"
                )
            }
        }
    }
}