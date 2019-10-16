package com.naxtre.layoutconversionproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.FlingAnimation
import androidx.recyclerview.widget.RecyclerView

class ImageRecyclerHorizontalListAdapter(val context: Context, val imagesArrayList :ArrayList<Int>) : RecyclerView.Adapter<ImageRecyclerHorizontalListAdapter.ViewHolder>() {
    var lastPosition : Int = 0
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageRecyclerHorizontalListAdapter.ViewHolder {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val mView = inflater.inflate(R.layout.recycler_view_image_view, parent, false)


        return ViewHolder(mView)
    }

    override fun getItemCount(): Int {
        return imagesArrayList.size
    }

    override fun onBindViewHolder(holder: ImageRecyclerHorizontalListAdapter.ViewHolder, position: Int) {

        holder.imageView.setImageResource(imagesArrayList.get(position))
        if(lastPosition > 0) {
            var animation: Animation = AnimationUtils.loadAnimation(context, R.anim.push_up_out)
            holder.imageView.startAnimation(animation)
            lastPosition = position
        }

    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageView)
    }


    override fun onViewDetachedFromWindow(holder: ViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.imageView.clearAnimation();
    }
}