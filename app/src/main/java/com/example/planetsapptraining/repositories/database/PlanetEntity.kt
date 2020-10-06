package com.example.planetsapptraining.repositories.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.planetsapptraining.domain.Planet

@Entity
data class PlanetEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "short_description") val shortDescription: String,
    @ColumnInfo(name = "image_url") val imageUrl: String,
    @ColumnInfo(name = "distance_from_sun") val distanceFromSun: Double,
    @ColumnInfo(name = "description") val description: String = "",
    @ColumnInfo(name = "planet_type") val planetType: String = "",
    @ColumnInfo(name = "surface_gravity") val surfaceGravity: Double = 0.0
) {
    fun mapToDomain(): Planet {
        return Planet(
            this.name,
            this.shortDescription,
            this.imageUrl,
            this.id,
            this.distanceFromSun,
            if (this.description == "") null else this.description,
            if (this.planetType == "") null else this.planetType,
            if (this.surfaceGravity == 0.0) null else this.surfaceGravity
        )
    }
}
