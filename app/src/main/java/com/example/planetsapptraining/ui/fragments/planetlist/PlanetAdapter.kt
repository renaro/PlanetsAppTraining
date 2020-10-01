package com.example.planetsapptraining.ui.fragments.planetlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.planetsapptraining.ui.fragments.planetdetail.PlanetViewState
import com.example.planetsapptraining.R
import kotlinx.android.synthetic.main.item_planet_list.view.*

class PlanetAdapter(
    private val planetListViewState: List<PlanetViewState>,
    private val context: Context?,
    private val itemTappedListener: (id: Int) -> Unit
) :
    RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_planet_list, parent, false)
        return PlanetViewHolder(view)
    }

    override fun getItemCount() = planetListViewState.size

    override fun onBindViewHolder(holder: PlanetViewHolder, position: Int) {
        val planetViewState = planetListViewState[position]
        holder.render(planetViewState)
    }

    inner class PlanetViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun render(viewState: PlanetViewState) {
            view.view_planet_list_item.render(viewState, itemTappedListener)
        }
    }
}
