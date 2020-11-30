package com.example.yebon.repeatudemykotlin.view.main.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.yebon.repeatudemykotlin.R
import com.example.yebon.repeatudemykotlin.view.main.home.presenter.HomeContract
import com.example.yebon.repeatudemykotlin.view.main.home.presenter.HomePresenter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeContract.View {

    private val presenter by lazy {
        HomePresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        refresh.setOnClickListener { presenter.loadImage() }
        presenter.loadImage()
    }

    override fun showImage(imageId: Int) {
        image.setImageResource(imageId)
    }

    override fun showProgress() {
        progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress.visibility = View.INVISIBLE
    }
}