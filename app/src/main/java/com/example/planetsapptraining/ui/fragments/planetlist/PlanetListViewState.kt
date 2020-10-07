package com.example.planetsapptraining.ui.fragments.planetlist

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlanetListViewState(val title: String, val planets: List<PlanetListItemViewState>) :
    Parcelable

