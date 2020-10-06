package com.example.planetsapptraining.repositories

import com.example.planetsapptraining.domain.Planet
import com.example.planetsapptraining.domain.PlanetRepository
import com.example.planetsapptraining.repositories.database.PlanetDao
import com.example.planetsapptraining.repositories.database.PlanetEntity
import com.example.planetsapptraining.repositories.retrofit.PlanetService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PlanetRepositoryImpl(
    private val service: PlanetService,
    private val planetDao: PlanetDao,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : PlanetRepository {

    override suspend fun getPlanetList(): List<Planet> {
        val planetListFromDb = withContext(dispatcher) {
            val planetList = planetDao.getAll()
            planetList.map {
                it.mapToDomain()
            }.sortedBy { it.distanceFromSun }
        }

        return if (planetListFromDb.isEmpty()) {
            val planets = getPlanetListFromApi()
            upsertPlanets(planets)
            planets
        } else planetListFromDb
    }

    override suspend fun getPlanetDetail(id: Int): Planet {
        val planet = withContext(dispatcher) {
            planetDao.findById(id)?.mapToDomain()
        }

        return if (planet == null || planet.description.isNullOrEmpty()) {
            val planet = getPlanetDetailFromApi(id)
            upsertPlanets(listOf(planet))
            planet
        } else planet
    }

    private suspend fun getPlanetDetailFromApi(id: Int): Planet {
        return withContext(dispatcher) {
            val planetWithDetails = service.getPlanetDetail(id)
            planetWithDetails.mapToDomain()
        }
    }

    private suspend fun getPlanetListFromApi(): List<Planet> {
        return withContext(dispatcher) {
            val planetList = service.getPlanetList()
            planetList.map {
                it.mapToDomain()
            }.sortedBy { it.distanceFromSun }
        }
    }

    private suspend fun upsertPlanets(planets: List<Planet>) {
        withContext(dispatcher) {
            planetDao.insertAll(planets.map {
                PlanetEntity(
                    it.id,
                    it.name,
                    it.shortDescription,
                    it.imageUrl,
                    it.distanceFromSun,
                    it.description ?: "",
                    it.planetType ?: "",
                    it.surfaceGravity ?: 0.0
                )
            })
        }
    }
}