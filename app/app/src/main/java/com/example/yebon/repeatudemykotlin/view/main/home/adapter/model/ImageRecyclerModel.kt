package com.example.yebon.repeatudemykotlin.view.main.home.adapter.model

import com.example.yebon.repeatudemykotlin.data.source.image.ImageData

interface ImageRecyclerModel {

    fun addItem(imageData: ImageData)

    fun getItemCount(): Int

    fun notifyDataSetChang()
}