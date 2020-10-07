package com.example.planetsapptraining.ui.fragments.planetlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.planetsapptraining.R
import com.example.planetsapptraining.ui.components.itemWithImage.ItemWithImageAndText
import com.example.planetsapptraining.ui.components.itemWithImage.ItemWithImageAndTextViewState
import kotlinx.android.synthetic.main.item_planet_list.view.*

class PlanetAdapter(
    private val context: Context?,
    private val itemTappedListener: (intent: ItemWithImageAndText.Intent) -> Unit
) :
    RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder>() {

    private var planetListViewState: List<PlanetListItemViewState> = emptyList()

    fun setViewState(planetListViewState: List<PlanetListItemViewState>) {
        this.planetListViewState = planetListViewState
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_planet_list, parent, false)
        view.view_planet_list_item.setListener(itemTappedListener)
        return PlanetViewHolder(view)
    }

    override fun getItemCount() = planetListViewState.size

    override fun onBindViewHolder(holder: PlanetViewHolder, position: Int) {
        val planetViewState = planetListViewState[position]
        holder.render(planetViewState)
    }

    inner class PlanetViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun render(viewState: PlanetListItemViewState) {
            view.view_planet_list_item.render(
                ItemWithImageAndTextViewState(
                    viewState.name,
                    viewState.shortDescription,
                    viewState.imageUrl,
                    viewState.id,
                    viewState.favorite
                )
            )
        }
    }
}
