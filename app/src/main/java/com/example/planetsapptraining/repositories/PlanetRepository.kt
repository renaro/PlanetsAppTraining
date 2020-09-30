package com.example.planetsapptraining.repositories

import com.example.planetsapptraining.Planet

interface PlanetRepository {
    suspend fun getPlanetList() : List<Planet>
    suspend fun getPlanetDetail(id: Int) : Planet
}