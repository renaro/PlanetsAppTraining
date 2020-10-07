package com.example.planetsapptraining.ui.fragments.planetdetail

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlanetViewState(
    val content: Content?,
    val error: Error?
) : Parcelable {
    @Parcelize
    data class Content(
        val name: String,
        val shortDescription: String,
        val imageUrl: String,
        val id: Int,
        val distanceFromSun: Double,
        val description: String? = null,
        val planetType: String? = null,
        val surfaceGravity: Double? = null,
        val favorite: Boolean = false
    ) : Parcelable

    @Parcelize
    data class Error(val message: String) : Parcelable
}