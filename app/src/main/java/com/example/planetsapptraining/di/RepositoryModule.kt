package com.example.planetsapptraining.di

import com.example.planetsapptraining.domain.PlanetRepository
import com.example.planetsapptraining.repositories.PlanetRepositoryImpl
import com.example.planetsapptraining.repositories.retrofit.PlanetService
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun providePlanetRepository(planetService: PlanetService): PlanetRepository {
        return PlanetRepositoryImpl(planetService)
    }
}