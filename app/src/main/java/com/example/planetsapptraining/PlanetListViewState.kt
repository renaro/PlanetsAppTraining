package com.example.planetsapptraining

import android.os.Parcelable
import com.example.planetsapptraining.ui.component.ItemWithImageAndTextViewState
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlanetListViewState(val title : String, val planets : List<PlanetListItemViewState>) : Parcelable

@Parcelize
data class PlanetListItemViewState (override val name : String, override val shortDescription : String, override val imageUrl : String) : Parcelable,
    ItemWithImageAndTextViewState