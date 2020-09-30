package com.example.planetsapptraining

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlanetListViewState(val title : String, val planets : List<PlanetViewState>) : Parcelable

