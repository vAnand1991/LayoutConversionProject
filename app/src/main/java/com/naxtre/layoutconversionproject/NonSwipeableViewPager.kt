package com.naxtre.layoutconversionproject

import android.content.Context
import android.util.AttributeSet
import android.view.animation.DecelerateInterpolator
import android.widget.Scroller
import java.lang.reflect.AccessibleObject.setAccessible
import androidx.viewpager.widget.ViewPager
import android.view.MotionEvent
import android.icu.lang.UCharacter.GraphemeClusterBreak.T




class NonSwipeableViewPager : ViewPager {
    private val mDuration = 500

    constructor(context: Context) : super(context) {
        setMyScroller()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        setMyScroller()
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        // Never allow swiping to switch between pages
        return false
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        // Never allow swiping to switch between pages
        return false
    }

    //down one is added for smooth scrolling

    private fun setMyScroller() {
        try {
            val viewpager = ViewPager::class.java
            val scroller = viewpager.getDeclaredField("mScroller")
            scroller.isAccessible = true
            scroller.set(this, MyScroller(context))
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    inner class MyScroller(context: Context) : Scroller(context, DecelerateInterpolator()) {

        override fun startScroll(startX: Int, startY: Int, dx: Int, dy: Int, duration: Int) {
            super.startScroll(startX, startY, dx, dy, 100 /*1 secs*/)
        }
    }


    /**
     * Returns the number of pages that will be retained to either side of the
     * current page in the view hierarchy in an idle state. Defaults to 1.
     *
     * @return How many pages will be kept offscreen on either side
     * @see .setOffscreenPageLimit
     */
    override fun getOffscreenPageLimit(): Int {
        return super.getOffscreenPageLimit()
    }

    /**
     * Set the number of pages that should be retained to either side of the
     * current page in the view hierarchy in an idle state. Pages beyond this
     * limit will be recreated from the adapter when needed.
     *
     *
     * This is offered as an optimization. If you know in advance the number
     * of pages you will need to support or have lazy-loading mechanisms in place
     * on your pages, tweaking this setting can have benefits in perceived smoothness
     * of paging animations and interaction. If you have a small number of pages (3-4)
     * that you can keep active all at once, less time will be spent in layout for
     * newly created view subtrees as the user pages back and forth.
     *
     *
     * You should keep this limit low, especially if your pages have complex layouts.
     * This setting defaults to 1.
     *
     * @param limit How many pages will be kept offscreen in an idle state.
     */
    override fun setOffscreenPageLimit(limit: Int) {
        super.setOffscreenPageLimit(limit)
    }
}
