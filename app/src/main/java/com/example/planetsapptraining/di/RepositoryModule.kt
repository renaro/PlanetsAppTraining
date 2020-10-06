package com.example.planetsapptraining.di

import android.content.Context
import com.example.planetsapptraining.domain.FavoriteRepository
import com.example.planetsapptraining.domain.PlanetRepository
import com.example.planetsapptraining.repositories.FavoriteRepositoryImpl
import com.example.planetsapptraining.repositories.PlanetRepositoryImpl
import com.example.planetsapptraining.repositories.database.PlanetDao
import com.example.planetsapptraining.repositories.retrofit.PlanetService
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule

@Module(includes = [AndroidInjectionModule::class])
class RepositoryModule {
    @Provides
    fun providePlanetRepository(
        planetService: PlanetService,
        planetDao: PlanetDao
    ): PlanetRepository {
        return PlanetRepositoryImpl(planetService, planetDao)
    }

    @Provides
    fun provideFavoriteRepository(context: Context): FavoriteRepository {
        return FavoriteRepositoryImpl(context)
    }
}