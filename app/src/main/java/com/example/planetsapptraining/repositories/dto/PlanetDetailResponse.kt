package com.example.planetsapptraining.repositories.dto

import com.example.planetsapptraining.domain.Planet

data class PlanetDetailResponse(
    val id: Int,
    val name: String,
    val shortDescription: String,
    val imageUrl: String,
    val distanceFromSun: Double,
    val description: String,
    val planetType: String,
    val surfaceGravity: Double
) {
    fun mapToDomain(): Planet =
        Planet(
            this.name,
            this.shortDescription,
            this.imageUrl,
            this.id,
            this.distanceFromSun,
            this.description,
            this.planetType,
            this.surfaceGravity
        )
}