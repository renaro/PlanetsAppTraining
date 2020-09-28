package com.example.planetsapptraining

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.planetsapptraining.repositories.PlanetRepositoryImpl
import kotlinx.coroutines.launch

class PlanetListViewModel : ViewModel() {

    private val planetRepository = PlanetRepositoryImpl()
    private val _viewState = MutableLiveData<PlanetListViewState>()
    val viewState: LiveData<PlanetListViewState>
        get() = _viewState

    fun getPlanetListViewState() {
        viewModelScope.launch {
            _viewState.value = PlanetListViewState("Planets", planetRepository.getPlanetList().map {
                PlanetListItemViewState(it.name, it.shortDescription, it.imageUrl)
            })
        }
    }
}