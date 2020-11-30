package com.example.yebon.repeatudemykotlin.data.source.image

object ImageRepository : ImageDataSource {

    private val imageLocalData: ImageLocalData by lazy {
        ImageLocalData()
    }

    override fun loadImageFileId(imageId: (Int) -> Unit) {
        imageLocalData.loadImageFileId(imageId)
    }
}