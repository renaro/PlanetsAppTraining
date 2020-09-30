package com.example.planetsapptraining.repositories

import com.example.planetsapptraining.repositories.dto.PlanetResponse
import org.junit.Test

import org.junit.Assert.*

class PlanetResponseTest {

    @Test
    fun mapToDomain() {
        val name = "Some name"
        val shortDescription = "Some short description"
        val imageUrl = "some.url.com"
        val response = PlanetResponse(1, name, shortDescription, imageUrl,0.1)
        val planet = response.mapToDomain()

        assertEquals(name, planet.name)
        assertEquals(shortDescription, planet.shortDescription)
        assertEquals(imageUrl, planet.imageUrl)
    }
}