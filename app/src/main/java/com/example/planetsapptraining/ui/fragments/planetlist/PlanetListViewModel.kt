package com.example.planetsapptraining.ui.fragments.planetlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.planetsapptraining.domain.FavoriteRepository
import com.example.planetsapptraining.domain.PlanetRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class PlanetListViewModel @Inject constructor(
    private val planetRepository: PlanetRepository,
    private val favoriteRepository: FavoriteRepository
) :
    ViewModel() {

    private val title: String = "Planets"
    private val _viewState = MutableLiveData<PlanetListViewState>()
    val viewState: LiveData<PlanetListViewState>
        get() = _viewState

    fun getPlanetListViewState() {
        viewModelScope.launch {
            val favorites = favoriteRepository.getFavorites()
            _viewState.value = PlanetListViewState(title, planetRepository.getPlanetList().map {
                PlanetListItemViewState(
                    it.name,
                    it.shortDescription,
                    it.imageUrl,
                    it.id,
                    it.distanceFromSun,
                    favorite = favorites.contains(it.id)
                )
            })
        }
    }

    fun handleIntent(intent: PlanetListFragment.Intent) {
        when (intent) {
            is PlanetListFragment.Intent.TappedOnFavorite -> {
                handleFavoriteTapped(intent)
            }
        }
    }

    private fun handleFavoriteTapped(intent: PlanetListFragment.Intent.TappedOnFavorite) {
        viewModelScope.launch {
            _viewState.value = _viewState.value?.let { planetsViewState ->
                PlanetListViewState(title, planetsViewState.planets.map {
                    if (it.id == intent.id) {
                        val newState = it.copy(favorite = !it.favorite)
                        when (newState.favorite) {
                            true -> favoriteRepository.saveFavorite(it.id)
                            false -> favoriteRepository.removeFavorite(it.id)
                        }
                        newState
                    } else
                        it
                })
            }
        }
    }
}