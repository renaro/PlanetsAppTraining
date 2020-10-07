package com.example.planetsapptraining.domain

interface PlanetRepository {
    suspend fun getPlanetList(): List<Planet>
    suspend fun getPlanetDetail(id: Int): Planet?
}