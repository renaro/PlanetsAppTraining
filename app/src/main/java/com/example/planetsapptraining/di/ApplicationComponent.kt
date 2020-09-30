package com.example.planetsapptraining.di

import com.example.planetsapptraining.ui.fragments.planetdetail.PlanetDetailFragment
import com.example.planetsapptraining.ui.fragments.planetlist.PlanetListFragment
import dagger.Component

@Component(modules = [NetworkModule::class, RepositoryModule::class])
interface ApplicationComponent {
    fun inject(planetDetailFragment: PlanetDetailFragment)
    fun inject(planetListFragment: PlanetListFragment)
}