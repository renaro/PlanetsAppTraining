package com.example.planetsapptraining.ui.fragments

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.planetsapptraining.*
import kotlinx.android.synthetic.main.fragment_planet_detail.*

class PlanetDetailFragment : Fragment() {

    private val arguments: PlanetDetailFragmentArgs by navArgs()
    private val viewModel: PlanetViewModel by viewModels()
    val handler = Handler()

    override fun onStart() {
        super.onStart()
        viewModel.viewState.observe(viewLifecycleOwner, Observer { render(it) })
        viewModel.getPlanetViewState(arguments.planetId)

        handler.postDelayed(object : Runnable {
            override fun run() {
                viewModel.getPlanetViewState(arguments.planetId)
                Toast.makeText(activity, "Data updated", Toast.LENGTH_SHORT).show()
                handler.postDelayed(this, 30000) // 30 sec delay
            }
        }, 0)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_planet_detail, container, false)
    }

    private fun render(viewState: PlanetViewState) {
        textPlanetName.text = viewState.name
        textPlanetShortDesc.text = viewState.shortDescription
        Glide.with(this).load(viewState.imageUrl).into(imagePlanet)
        view_detail_row_distance_from_sun.render("Distance from sun", viewState.distanceFromSun.toString())
        view_detail_row_surface_gravity.render("Surface gravity", viewState.surfaceGravity.toString())
        view_detail_row_planet_type.render("Planet type", viewState.planetType.toString())
        view_detail_row_description.render("Description", viewState.description.toString())
    }
}