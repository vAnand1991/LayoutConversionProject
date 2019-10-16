package com.naxtre.layoutconversionproject


import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.os.Handler
import android.view.LayoutInflater

import androidx.recyclerview.widget.LinearLayoutManager

import java.util.*
import kotlin.collections.ArrayList

import android.view.animation.TranslateAnimation

import android.view.View
import android.view.animation.Animation
import android.widget.FrameLayout

import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.create_personal_hotspot_fragment_layout.*
import kotlinx.android.synthetic.main.layout_edit_node.*


class MainActivity : AppCompatActivity(), Animation.AnimationListener {
    lateinit var handler: Handler
    lateinit var imageRecyclerHorizontalListAdapter: ImageRecyclerHorizontalListAdapter
    lateinit var imagesDrawableArrayList: ArrayList<Int>
    lateinit var animation_custom: AnimationDrawable
    var position: Int = 0
    var lastPosition: Int = 0
    var nextPosition: Int = 0
    lateinit var slideUpAnimation: Animation
    lateinit var upFromBottomAnimation: Animation
    lateinit var imageViewList: ArrayList<ImageView>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_edit_node)
        val layoutManager = CustomGridLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        view_pager_voice_assistant.adapter = VoicePagerAdapter(supportFragmentManager)
        view_pager_voice_assistant.offscreenPageLimit = 0
//        sliding_tabs.setupWithViewPager(view_pager_voice_assistant)
        var inflatedLayout: FrameLayout = LayoutInflater.from(this).inflate(R.layout.tab_internal_custom_layout, null) as FrameLayout
        var textView: TextView = inflatedLayout.findViewById(R.id.teb_name)
        textView.setText("asdkasnd")
        sliding_tabs.addTab(sliding_tabs.newTab().setCustomView(inflatedLayout))
        sliding_tabs.addTab(sliding_tabs.newTab().setCustomView(inflatedLayout))
        sliding_tabs.addTab(sliding_tabs.newTab().setCustomView(inflatedLayout))
        sliding_tabs.addTab(sliding_tabs.newTab().setCustomView(inflatedLayout))

        /*sliding_tabs.getTabAt(0)!!.setCustomView(R.layout.tab_internal_custom_layout)
        sliding_tabs.getTabAt(1)!!.setCustomView(R.layout.tab_internal_custom_layout)
        sliding_tabs.getTabAt(2)!!.setCustomView(R.layout.tab_internal_custom_layout)
        sliding_tabs.getTabAt(3)!!.setCustomView(R.layout.tab_internal_custom_layout)*/

        sliding_tabs.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {

            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {

            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                view_pager_voice_assistant.setCurrentItem(p0!!.position, true)
            }
        })

        sliding_tabs.getTabAt(0)!!.select()

        /* recycler_view.setLayoutManager(layoutManager)
         imageRecyclerHorizontalListAdapter = ImageRecyclerHorizontalListAdapter(this,imagesDrawableArrayList)
         recycler_view.adapter = imageRecyclerHorizontalListAdapter*/
// Pass it to the constructor
        /* val flingAnimation = FlingAnimation(recycler_view, DynamicAnimation.Y)
         flingAnimation.setStartVelocity(10f)
         flingAnimation.setFriction(0.5f)
         flingAnimation.start()*/

        /*image_view.apply {
            setBackgroundResource(R.drawable.animation_custom)
            animation_custom = background as AnimationDrawable
        }*/
        /* val countDownTime = object : CountDownTimer((imageRecyclerHorizontalListAdapter.itemCount  * 2000).toLong(),2000){
             override fun onFinish() {
                 layoutManager.setScrollVertical(false)
                 recycler_view.layoutManager = layoutManager
             }

             override fun onTick(p0: Long) {
                     recycler_view.smoothScrollToPosition(position++)
             }
         }
         countDownTime.start()*/

//        slideToTop(image_view)

        /*slideUpAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_up)
        upFromBottomAnimation = AnimationUtils.loadAnimation(this, R.anim.up_from_bottom)
        slideUpAnimation.setAnimationListener(null)
        upFromBottomAnimation.setAnimationListener(this)
        imageViewList = ArrayList<ImageView>()
        for (i in 0..imagesDrawableArrayList.size - 1) {
            var imageView = ImageView(this)
            val layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )
            imageView.layoutParams = layoutParams
            imageView.visibility = View.INVISIBLE
            imageViewList.add(imageView)
            frameLayout.addView(imageView)
        }

        imageViewList.get(position).setImageResource(imagesDrawableArrayList.get(position))
        imageViewList.get(position).visibility = View.VISIBLE
        imageViewList.get(position).startAnimation(slideUpAnimation)
        position++
*/

        /*object: Animation.AnimationListener {
        override fun onAnimationRepeat(p0: Animation?) {

        }

        override fun onAnimationEnd(p0: Animation?) {

            imageView1.visibility = View.INVISIBLE
            imageView2.visibility = View.VISIBLE
            imageView2.startAnimation(upFromBottomAnimation)
        }

        override fun onAnimationStart(p0: Animation?) {
            imageView2.setImageResource(imagesDrawableArrayList.get(1))
        }
    })*/

        /*upFromBottomAnimation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationRepeat(p0: Animation?) {

            }

            override fun onAnimationEnd(p0: Animation?) {
                imageView2.visibility = View.GONE
                imageView1.visibility = View.VISIBLE
                imageView1.startAnimation(upFromBottomAnimation)
            }

            override fun onAnimationStart(p0: Animation?) {
                imageView1.setImageResource(imagesDrawableArrayList.get(2))
            }
        })*/

    }

    override fun onAnimationRepeat(p0: Animation?) {

    }

    override fun onAnimationEnd(p0: Animation?) {
        if (position < imagesDrawableArrayList.size - 1) {
            imageViewList.get(lastPosition).visibility = View.INVISIBLE
            imageViewList.get(position).visibility = View.VISIBLE
            imageViewList.get(lastPosition).startAnimation(slideUpAnimation)
            imageViewList.get(position).startAnimation(upFromBottomAnimation)
            lastPosition = position
            position++
        }
    }

    override fun onAnimationStart(p0: Animation?) {
        imageViewList.get(position).setImageResource(imagesDrawableArrayList.get(position))
    }


    /* if(position < imagesDrawableArrayList.size - 1)
        if(imageView2.visibility == View.INVISIBLE){
            imageView1.visibility = View.INVISIBLE
            imageView2.visibility = View.VISIBLE
            imageView2.startAnimation(upFromBottomAnimation)
        } else if (imageView1.visibility == View.INVISIBLE){
            imageView2.visibility = View.GONE
            imageView1.visibility = View.VISIBLE
            imageView1.startAnimation(upFromBottomAnimation)
        }
    }

    override fun onAnimationStart(p0: Animation?) {
        if(imageView2.visibility == View.INVISIBLE)
            imageView2.setImageResource(imagesDrawableArrayList.get(position++))
        else if (imageView1.visibility == View.INVISIBLE)
            imageView1.setImageResource(imagesDrawableArrayList.get(position++))*/

    override fun onResume() {
        super.onResume()
    }

    override fun onStart() {
        super.onStart()
//        animation_custom.start()
    }

    // To animate view slide out from top to bottom
    fun slideToBottom(view: ImageView) {
        val animate = TranslateAnimation(0f, 0f, 0f, view.getHeight().toFloat())
        animate.duration = 2000
        animate.fillAfter = true
        view.startAnimation(animate)
        view.setVisibility(View.GONE)
    }

    // To animate view slide out from bottom to top
    fun slideToTop(view: ImageView) {
        val animate = TranslateAnimation(0f, 0f, 0f, (-view.height).toFloat())
        animate.duration = 2000
        animate.fillAfter = true
        view.startAnimation(animate)
        view.visibility = View.GONE
    }


}
