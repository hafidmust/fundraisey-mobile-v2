package com.hafidmust.fundraisey_v2.presentation.information

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.hafidmust.fundraisey_v2.R

class AccordionView(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {
    private var isExpanded = false
    private var header : TextView
    private var content : TextView
    private var arrow : ImageView

    init {
        LayoutInflater.from(context).inflate(R.layout.view_accordion, this, true)
        header = findViewById(R.id.header)
        content = findViewById(R.id.content)
        arrow = findViewById(R.id.arrow)

        header.setOnClickListener {
            toggleAccordion()
        }
    }

    private fun toggleAccordion() {
        isExpanded = !isExpanded
        if (isExpanded) {
            content.visibility = VISIBLE
            arrow.setImageResource(R.drawable.baseline_keyboard_arrow_up_24)
        } else {
            content.visibility = GONE
            arrow.setImageResource(R.drawable.baseline_keyboard_arrow_down_24)
        }
    }

    fun setHeaderText(text: String) {
        header.text = text
    }

    fun setContentText(text: String) {
        content.text = text
    }
}
