package com.example.planetsapptraining.ui.fragments.planetdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.planetsapptraining.domain.PlanetRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class PlanetViewModel @Inject constructor(val planetRepository: PlanetRepository) : ViewModel() {
    private val _viewState = MutableLiveData<PlanetViewState>()
    val viewState: LiveData<PlanetViewState>
        get() = _viewState

    fun getPlanetViewState(id: Int) {
        viewModelScope.launch {
            val planet = planetRepository.getPlanetDetail(id)
            _viewState.value = PlanetViewState(
                name = planet.name,
                shortDescription = planet.shortDescription,
                imageUrl = planet.imageUrl,
                id = planet.id,
                distanceFromSun = planet.distanceFromSun,
                description = planet.description,
                planetType = planet.planetType,
                surfaceGravity = planet.surfaceGravity
            )
        }
    }
}
