package com.example.yebon.repeatudemykotlin.data.source.image

import com.example.yebon.repeatudemykotlin.R
import java.security.SecureRandom

class ImageLocalData : ImageDataSource {

    private val mImageIds = intArrayOf(
        R.drawable.sample_01, R.drawable.sample_02, R.drawable.sample_03,
        R.drawable.sample_04, R.drawable.sample_05, R.drawable.sample_06, R.drawable.sample_07,
        R.drawable.sample_08, R.drawable.sample_09, R.drawable.sample_10)

    override fun loadImageFileId(imageId: (Int) -> Unit) {
        val idx = SecureRandom().nextInt(mImageIds.size)
        imageId(mImageIds[idx])
    }
}