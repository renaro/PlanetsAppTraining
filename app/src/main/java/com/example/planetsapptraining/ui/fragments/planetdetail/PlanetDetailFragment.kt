package com.example.planetsapptraining.ui.fragments.planetdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.planetsapptraining.App
import com.example.planetsapptraining.R
import kotlinx.android.synthetic.main.fragment_planet_detail.*
import javax.inject.Inject

class PlanetDetailFragment : Fragment() {

    private val arguments: PlanetDetailFragmentArgs by navArgs()

    @Inject
    lateinit var viewModel: PlanetViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().applicationContext as App).appComponent.inject(this)
    }

    override fun onStart() {
        super.onStart()
        viewModel.viewState.observe(viewLifecycleOwner, { render(it) })
        viewModel.getPlanetViewState(arguments.planetId)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_planet_detail, container, false)
    }

    private fun render(viewState: PlanetViewState) {
        if (viewState.content == null) {
            Toast.makeText(
                this.requireActivity().applicationContext,
                viewState.error?.message ?: "Error while loading the planet",
                Toast.LENGTH_SHORT
            ).show()
            findNavController().popBackStack()
        } else {
            textPlanetName.text = viewState.content.name
            textPlanetShortDesc.text = viewState.content.shortDescription
            Glide.with(this).load(viewState.content.imageUrl).into(imagePlanet)
            view_detail_row_distance_from_sun.render(
                "Distance from sun",
                viewState.content.distanceFromSun.toString()
            )
            view_detail_row_surface_gravity.render(
                "Surface gravity",
                viewState.content.surfaceGravity.toString()
            )
            view_detail_row_planet_type.render(
                "Planet type",
                viewState.content.planetType.toString()
            )
            view_detail_row_description.render(
                "Description",
                viewState.content.description.toString()
            )
        }


    }
}