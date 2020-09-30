package com.example.planetsapptraining.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.planetsapptraining.*
import com.example.planetsapptraining.ui.component.itemWithImage.ItemTappedListener
import com.example.planetsapptraining.ui.component.itemWithImage.ItemWithImageAndTextViewState
import kotlinx.android.synthetic.main.fragment_planet_list.*

class PlanetListFragment : Fragment(), ItemTappedListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: PlanetAdapter
    private val viewModel: PlanetListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_planet_list, container, false)
    }

    override fun onStart() {
        super.onStart()
        viewModel.viewState.observe(viewLifecycleOwner, Observer { render(it) })
        viewModel.getPlanetListViewState()
    }

    private fun render(viewState: PlanetListViewState) {

        textPlanetsTitle.text = viewState.title

        viewAdapter = PlanetAdapter(
            viewState.planets,
            requireContext(),
            this
        )

        recyclerView = recycler_view_planets.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = viewAdapter
        }
    }

    override fun onItemTapped(item: ItemWithImageAndTextViewState) {
        findNavController(this).navigate(
            PlanetListFragmentDirections.actionPlanetListFragmentToPlanetDetailFragment(
                item.id
            )
        )
    }
}


