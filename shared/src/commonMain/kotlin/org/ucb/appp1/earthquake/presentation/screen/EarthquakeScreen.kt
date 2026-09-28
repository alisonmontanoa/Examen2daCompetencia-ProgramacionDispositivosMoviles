package org.ucb.appp1.earthquake.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.compose.viewmodel.koinViewModel
import org.ucb.appp1.earthquake.domain.model.Earthquake
import org.ucb.appp1.earthquake.presentation.viewmodel.EarthquakeEvent
import org.ucb.appp1.earthquake.presentation.viewmodel.EarthquakeViewModel

@Composable
fun EarthquakeScreen(
    viewModel: EarthquakeViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.onEvent(EarthquakeEvent.LoadEarthquakes)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "USGS Earthquakes",
            style = MaterialTheme.typography.headlineMedium
        )

        when {
            state.isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier.padding(top = 24.dp)
                )
            }

            state.error != null -> {
                Column(
                    modifier = Modifier.padding(top = 24.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = state.error ?: "Error desconocido"
                    )

                    Button(
                        onClick = {
                            viewModel.onEvent(EarthquakeEvent.LoadEarthquakes)
                        }
                    ) {
                        Text("Reintentar")
                    }
                }
            }

            state.earthquakes.isEmpty() -> {
                Text(
                    text = "No se encontraron terremotos.",
                    modifier = Modifier.padding(top = 24.dp)
                )
            }

            else -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(vertical = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(state.earthquakes) { earthquake ->
                        EarthquakeItem(earthquake)
                    }
                }
            }
        }
    }
}

@Composable
private fun EarthquakeItem(
    earthquake: Earthquake
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = earthquake.place,
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = "Magnitud: ${earthquake.magnitude ?: "N/D"}"
            )

            Text(
                text = "Fecha/hora: ${earthquake.time ?: "N/D"}"
            )

            Text(
                text = "Longitud: ${earthquake.longitude}"
            )

            Text(
                text = "Latitud: ${earthquake.latitude}"
            )

            Text(
                text = "Profundidad: ${earthquake.depth} km"
            )

            Text(
                text = "Enlace: ${earthquake.url ?: "N/D"}"
            )
        }
    }
}