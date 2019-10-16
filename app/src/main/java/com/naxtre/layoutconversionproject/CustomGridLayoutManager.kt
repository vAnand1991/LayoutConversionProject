package com.naxtre.layoutconversionproject

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager

class CustomGridLayoutManager(val context: Context, val horizontal: Int, val reverse: Boolean ): LinearLayoutManager(context,horizontal,reverse) {
    internal var scrollVertical: Boolean = true

    fun setScrollVertical(scrollVertical: Boolean){
        this.scrollVertical = scrollVertical
    }
    override fun canScrollVertically(): Boolean {
        return scrollVertical
    }
}