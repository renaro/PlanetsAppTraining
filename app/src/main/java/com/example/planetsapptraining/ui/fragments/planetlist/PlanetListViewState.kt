package com.example.planetsapptraining.ui.fragments.planetlist

import android.os.Parcelable
import com.example.planetsapptraining.ui.fragments.planetdetail.PlanetViewState
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlanetListViewState(val title : String, val planets : List<PlanetViewState>) : Parcelable

