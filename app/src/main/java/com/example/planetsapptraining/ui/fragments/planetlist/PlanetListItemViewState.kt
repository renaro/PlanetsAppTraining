package com.example.planetsapptraining.ui.fragments.planetlist

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlanetListItemViewState(
    val name: String,
    val shortDescription: String,
    val imageUrl: String,
    val id: Int,
    val distanceFromSun: Double,
    val favorite: Boolean
) : Parcelable