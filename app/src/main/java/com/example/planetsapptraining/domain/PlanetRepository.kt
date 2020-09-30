package com.example.planetsapptraining.domain

import com.example.planetsapptraining.domain.Planet

interface PlanetRepository {
    suspend fun getPlanetList() : List<Planet>
    suspend fun getPlanetDetail(id: Int) : Planet
}