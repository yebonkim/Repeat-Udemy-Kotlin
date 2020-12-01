package com.example.yebon.repeatudemykotlin.view.main.home.adapter.holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yebon.repeatudemykotlin.R
import com.example.yebon.repeatudemykotlin.data.source.image.ImageData
import kotlinx.android.synthetic.main.item_image_view.view.*

class ImageViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_image_view, parent, false)
) {

    fun onBind(item: ImageData) {
        itemView.onBind(item)
    }

    private fun View.onBind(item: ImageData) {
        tv_title.text = item.name
        img_view.setImageResource(item.drawableId)
    }
}