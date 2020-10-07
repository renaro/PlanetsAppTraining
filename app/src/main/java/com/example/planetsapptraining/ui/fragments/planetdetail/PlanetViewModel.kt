package com.example.planetsapptraining.ui.fragments.planetdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.planetsapptraining.domain.PlanetRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class PlanetViewModel @Inject constructor(private val planetRepository: PlanetRepository) :
    ViewModel() {
    private val _viewState = MutableLiveData<PlanetViewState>()
    val viewState: LiveData<PlanetViewState>
        get() = _viewState

    fun getPlanetViewState(id: Int) {
        viewModelScope.launch {
            val planet = planetRepository.getPlanetDetail(id)
            _viewState.value = if (planet != null) {
                PlanetViewState(
                    content = PlanetViewState.Content(
                        name = planet.name,
                        shortDescription = planet.shortDescription,
                        imageUrl = planet.imageUrl,
                        id = planet.id,
                        distanceFromSun = planet.distanceFromSun,
                        description = planet.description,
                        planetType = planet.planetType,
                        surfaceGravity = planet.surfaceGravity
                    ),
                    error = null
                )
            } else {
                PlanetViewState(
                    content = null,
                    error = PlanetViewState.Error("Unable to load planet.")
                )
            }
        }
    }
}
