package com.example.planetsapptraining.di

import android.content.Context
import androidx.room.Room
import com.example.planetsapptraining.R
import com.example.planetsapptraining.repositories.database.AppDatabase
import com.example.planetsapptraining.repositories.database.PlanetDao
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule

@Module(includes = [AndroidInjectionModule::class])
class DatabaseModule {

    @Provides
    fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, context.getString(R.string.database_name)
        ).build()
    }

    @Provides
    fun providePlanetDao(appDatabase: AppDatabase): PlanetDao {
        return appDatabase.planetDao()
    }

}
