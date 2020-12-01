package com.example.yebon.repeatudemykotlin.data.source.image

interface ImageDataSource {

    fun loadImageList(imageDataList: (List<ImageData>) -> Unit, size: Int)
}