package com.example.yebon.repeatudemykotlin.data.source.image

interface ImageDataSource {

    fun loadImageFileId(imageId: (Int) -> Unit)
}