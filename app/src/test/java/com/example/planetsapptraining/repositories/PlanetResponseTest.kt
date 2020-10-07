package com.example.planetsapptraining.repositories

import com.example.planetsapptraining.repositories.dto.PlanetDetailResponse
import com.example.planetsapptraining.repositories.dto.PlanetResponse
import org.junit.Assert.assertEquals
import org.junit.Test

class PlanetResponseTest {

    @Test
    fun mapToDomain() {
        val name = "Some name"
        val shortDescription = "Some short description"
        val imageUrl = "some.url.com"
        val response = PlanetResponse(1, name, shortDescription, imageUrl, 0.1)
        val planet = response.mapToDomain()

        assertEquals(name, planet.name)
        assertEquals(shortDescription, planet.shortDescription)
        assertEquals(imageUrl, planet.imageUrl)
    }

    @Test
    fun mapToDomainDetail() {
        val response = PlanetDetailResponse(
            1,
            "Planet 1",
            "short description",
            "some.url.for.the.image",
            1.0,
            "description",
            "planet type",
            1.0
        )

        val planet = response.mapToDomain()

        assertEquals(planet.name, response.name)
        assertEquals(planet.distanceFromSun, response.distanceFromSun, 0.00001)
        assertEquals(planet.description, response.description)
        assertEquals(planet.id, response.id)
        assertEquals(planet.imageUrl, response.imageUrl)
        assertEquals(planet.planetType, response.planetType)
        assertEquals(planet.shortDescription, response.shortDescription)
        planet.surfaceGravity?.let {
            assertEquals(
                it,
                response.surfaceGravity,
                0.00001
            )
        }
    }
}