package com.example.planetsapptraining.ui.fragments.planetlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.planetsapptraining.ui.fragments.planetdetail.PlanetViewState
import com.example.planetsapptraining.R
import com.example.planetsapptraining.ui.components.itemWithImage.ItemTappedListener
import kotlinx.android.synthetic.main.item_planet_list.view.*

class PlanetAdapter(
    private val planetListViewState: List<PlanetViewState>,
    private val context: Context?,
    private val itemTappedListener: ItemTappedListener
) :
    RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_planet_list, parent, false)
        view.view_planet_list_item.setItemListener(itemTappedListener)
        return PlanetViewHolder(view)
    }

    override fun getItemCount() = planetListViewState.size

    override fun onBindViewHolder(holder: PlanetViewHolder, position: Int) {
        val planetViewState = planetListViewState[position]
        holder.render(planetViewState)
    }

    inner class PlanetViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun render(viewState: PlanetViewState) {
            view.view_planet_list_item.render(viewState)
        }
    }
}
