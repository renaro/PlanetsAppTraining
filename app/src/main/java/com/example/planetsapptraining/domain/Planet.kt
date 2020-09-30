package com.example.planetsapptraining.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Planet (
    val name : String,
    val shortDescription : String,
    val imageUrl: String,
    val id: Int,
    val distanceFromSun: Double,
    val description: String? = null,
    val planetType: String? = null,
    val surfaceGravity: Double? = null) : Parcelable {
    override fun toString(): String {
        return name
    }
}