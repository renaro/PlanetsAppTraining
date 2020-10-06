package com.example.planetsapptraining.di

import android.content.Context
import com.example.planetsapptraining.ui.fragments.planetdetail.PlanetDetailFragment
import com.example.planetsapptraining.ui.fragments.planetlist.PlanetListFragment
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = [NetworkModule::class, RepositoryModule::class, DatabaseModule::class,
        AndroidSupportInjectionModule::class]
)
interface ApplicationComponent {
    fun inject(planetDetailFragment: PlanetDetailFragment)
    fun inject(planetListFragment: PlanetListFragment)

    // Necessary so that the Context can be injected in the repository
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun build(): ApplicationComponent
    }
}