package com.example.planetsapptraining.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.planetsapptraining.PlanetMockedData
import com.example.planetsapptraining.R
import kotlinx.android.synthetic.main.fragment_planet_detail.*

class PlanetDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_planet_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val planet = PlanetMockedData.planets[0]

        textPlanetName.text = planet.name
        textPlanetShortDesc.text = planet.shortDescription
    }

}