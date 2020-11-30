package com.example.yebon.repeatudemykotlin.view.main.home.presenter

import android.os.AsyncTask
import com.example.yebon.repeatudemykotlin.data.source.image.ImageRepository

class HomePresenter(
    private val mView: HomeContract.View,
    private val mImageRepository: ImageRepository): HomeContract.Presenter {

    override fun loadImage() {
        ImageAsyncTask(mView, mImageRepository).execute()
    }

    class ImageAsyncTask(private val view: HomeContract.View,
                         private val mImageRepository: ImageRepository) : AsyncTask<Unit, Unit, Unit>() {

        private val SLEEP_TIME = 1000L

        override fun doInBackground(vararg params: Unit?) {
            Thread.sleep(SLEEP_TIME)
        }

        override fun onPreExecute() {
            super.onPreExecute()

            view.showProgress()
        }

        override fun onPostExecute(result: Unit?) {
            super.onPostExecute(result)

            view.hideProgress()
            mImageRepository.loadImageFileId {
                view.showImage(it)
            }
        }

    }
}