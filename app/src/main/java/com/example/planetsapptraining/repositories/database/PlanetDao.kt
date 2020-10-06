package com.example.planetsapptraining.repositories.database

import androidx.room.*

@Dao
interface PlanetDao {
    @Query("SELECT * FROM PlanetEntity")
    fun getAll(): List<PlanetEntity>

    @Query("SELECT * FROM PlanetEntity WHERE id = :id LIMIT 1")
    fun findById(id: Int): PlanetEntity?

    @Query("SELECT * FROM PlanetEntity WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): PlanetEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(planets: List<PlanetEntity>)

    @Delete
    fun delete(planet: PlanetEntity)
}