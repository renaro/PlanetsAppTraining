package com.example.planetsapptraining.repositories.retrofit

import com.example.planetsapptraining.repositories.dto.PlanetDetailResponse
import com.example.planetsapptraining.repositories.dto.PlanetResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PlanetService {
    @GET("training/planets")
    suspend fun getPlanetList(): List<PlanetResponse>

    @GET("training/planets/{id}")
    suspend fun getPlanetDetail(
        @Path("id")
        id: Int
    ): PlanetDetailResponse
}