package com.example.planetsapptraining.repositories

import com.example.planetsapptraining.domain.Planet
import com.example.planetsapptraining.domain.PlanetRepository
import com.example.planetsapptraining.repositories.retrofit.PlanetService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PlanetRepositoryImpl(
    private val service: PlanetService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : PlanetRepository {

    override suspend fun getPlanetList(): List<Planet> {
        return withContext(dispatcher) {
            val planetList = service.getPlanetList()
            planetList.map {
                it.mapToDomain()
            }.sortedBy { it.distanceFromSun }
        }
    }

    override suspend fun getPlanetDetail(id: Int): Planet {
        return withContext(dispatcher) {
            val planet = service.getPlanetDetail(id)
            planet.mapToDomain()
        }
    }
}