package com.example.yebon.repeatudemykotlin.view.main.home.presenter

import android.os.AsyncTask
import com.example.yebon.repeatudemykotlin.R
import java.security.SecureRandom

class HomePresenter(private val mView: HomeContract.View): HomeContract.Presenter {

    override fun loadImage() {
        ImageAsyncTask(mView).execute()
    }

    class ImageAsyncTask(private val view: HomeContract.View) : AsyncTask<Unit, Unit, Int>() {

        private val SLEEP_TIME = 1000L

        private val mImageIds = intArrayOf(R.drawable.sample_01, R.drawable.sample_02, R.drawable.sample_03,
                R.drawable.sample_04, R.drawable.sample_05, R.drawable.sample_06, R.drawable.sample_07,
                R.drawable.sample_08, R.drawable.sample_09, R.drawable.sample_10)

        override fun doInBackground(vararg params: Unit?): Int {
            Thread.sleep(SLEEP_TIME)

            return SecureRandom().nextInt(mImageIds.size)
        }

        override fun onPreExecute() {
            super.onPreExecute()

            view.showProgress()
        }

        override fun onPostExecute(result: Int?) {
            super.onPostExecute(result)

            view.hideProgress()
            val imageId = mImageIds[result ?: 0]
            view.showImage(imageId)
        }

    }
}