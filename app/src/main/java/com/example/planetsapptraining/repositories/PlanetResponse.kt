package com.example.planetsapptraining.repositories

import com.example.planetsapptraining.Planet

data class PlanetResponse(
    val id: Int,
    val name: String,
    val shortDescription: String,
    val imageUrl: String,
    val distanceFromSun: Double
) {
    fun mapToDomain(): Planet =
        Planet(this.name, this.shortDescription, this.imageUrl, this.id, this.distanceFromSun)
}

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