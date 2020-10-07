package com.example.planetsapptraining.ui.components.itemWithImage

import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.example.planetsapptraining.R
import kotlinx.android.synthetic.main.item_image_text_view.view.*

class ItemWithImageAndText
@JvmOverloads
constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    ConstraintLayout(context, attrs, defStyleAttr) {

    var itemListener: (intent: Intent) -> Unit = {}
    private var currentViewState: ItemWithImageAndTextViewState? = null

    init {
        View.inflate(context, R.layout.item_image_text_view, this)
        setOnClickListener { currentViewState?.let { itemListener(Intent.ItemClicked(it.id)) } }
        imageFavorite.setOnClickListener {
            currentViewState?.let {
                itemListener(
                    Intent.TappedOnFavorite(
                        it.id
                    )
                )
            }
        }
    }

    fun setListener(itemListener: (intent: Intent) -> Unit) {
        this.itemListener = itemListener
    }

    fun render(viewState : ItemWithImageAndTextViewState) {
        currentViewState = viewState
        textItemName.text = viewState.name
        textItemShortDesc.text = viewState.shortDescription
        Glide.with(this).load(viewState.imageUrl).into(imageItem)
        renderFavorite(viewState)
    }

    private fun renderFavorite(viewState: ItemWithImageAndTextViewState) {
        if (viewState.favorite)
            imageFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
        else
            imageFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
    }

    sealed class Intent {
        data class ItemClicked(val id: Int): Intent()
        data class TappedOnFavorite(val id: Int): Intent()
    }
}
