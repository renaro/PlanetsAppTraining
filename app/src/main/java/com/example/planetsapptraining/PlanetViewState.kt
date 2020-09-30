package com.example.planetsapptraining

import android.os.Parcelable
import com.example.planetsapptraining.ui.component.itemWithImage.ItemWithImageAndTextViewState
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlanetViewState(
    override val name: String,
    override val shortDescription: String,
    override val imageUrl: String,
    override val id: Int,
    val distanceFromSun: Double,
    val description: String? = null,
    val planetType: String? = null,
    val surfaceGravity: Double? = null
) : Parcelable,
    ItemWithImageAndTextViewState