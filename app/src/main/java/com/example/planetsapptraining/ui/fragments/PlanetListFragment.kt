package com.example.planetsapptraining.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.planetsapptraining.Planet
import com.example.planetsapptraining.PlanetMockedData
import com.example.planetsapptraining.R
import kotlinx.android.synthetic.main.fragment_planet_list.*


class PlanetListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_planet_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val localContext = requireContext()

        val adapterPlanets = ArrayAdapter(
            localContext,
            android.R.layout.simple_list_item_1,
            PlanetMockedData.planets
        )

        listPlanets.adapter = adapterPlanets

        listPlanets.setOnItemClickListener { _, _, position, _ ->
            val planet = adapterPlanets.getItem(position) as Planet
            findNavController().navigate(PlanetListFragmentDirections.actionPlanetListFragmentToPlanetDetailFragment())
        }
    }
}