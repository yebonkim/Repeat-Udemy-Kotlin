package com.example.yebon.repeatudemykotlin.view.main.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yebon.repeatudemykotlin.R
import com.example.yebon.repeatudemykotlin.data.source.image.ImageRepository
import com.example.yebon.repeatudemykotlin.view.main.home.adapter.ImageRecyclerAdapter
import com.example.yebon.repeatudemykotlin.view.main.home.presenter.HomeContract
import com.example.yebon.repeatudemykotlin.view.main.home.presenter.HomePresenter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeContract.View {

    private val presenter by lazy {
        HomePresenter(this@HomeFragment, ImageRepository, imageRecyclerAdapter)
    }

    private val imageRecyclerAdapter: ImageRecyclerAdapter by lazy {
        ImageRecyclerAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.loadImage()

        recycler_view.run {
            adapter = imageRecyclerAdapter
            layoutManager = GridLayoutManager(this@HomeFragment.context, 3)
            addOnScrollListener(recyclerViewOnScrollListener)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        recycler_view?.removeOnScrollListener(recyclerViewOnScrollListener)
    }

    override fun showProgress() {
        progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress.visibility = View.INVISIBLE
    }

    private val recyclerViewOnScrollListener = object : RecyclerView.OnScrollListener() {

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            val visibleItemCount = recyclerView.childCount
            val totalItemCount = imageRecyclerAdapter.itemCount
            val firstVisibleItem = (recyclerView.layoutManager as? GridLayoutManager)?.findFirstVisibleItemPosition()
                ?: 0

            if (!presenter.isLoading && (firstVisibleItem + visibleItemCount) >= totalItemCount - 7) {
                presenter.loadImage()
            }
        }
    }
}