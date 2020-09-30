package com.example.planetsapptraining.ui.component.detailRow

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.planetsapptraining.R
import kotlinx.android.synthetic.main.detail_row_view.view.*

class DetailRow
@JvmOverloads
constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.detail_row_view, this)
    }

    fun render(title: String, value: String) {
        textTitle.text = title
        textDescription.text = value
    }
}