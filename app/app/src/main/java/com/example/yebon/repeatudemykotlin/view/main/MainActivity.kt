package com.example.yebon.repeatudemykotlin.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.yebon.repeatudemykotlin.R
import com.example.yebon.repeatudemykotlin.chapter1.util.Utils
import com.example.yebon.repeatudemykotlin.chapter1.util.replace
import com.example.yebon.repeatudemykotlin.view.main.home.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val homeFragment: HomeFragment by lazy {
        HomeFragment().apply {
            arguments = Bundle().apply {
                putInt(Utils.KEY_TITLE, R.string.title_home)
            }
        }
    }

    private val cameraFragment: CameraFragment by lazy {
        CameraFragment().apply {
            arguments = Bundle().apply {
                putInt(Utils.KEY_TITLE, R.string.title_camera)
            }
        }
    }

    private val moreFragment: MoreFragment by lazy {
        MoreFragment().apply {
            arguments = Bundle().apply {
                putInt(Utils.KEY_TITLE, R.string.title_more)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replace(R.id.container, homeFragment)

        navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    replace(R.id.container, homeFragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_camera -> {
                    replace(R.id.container, cameraFragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_more -> {
                    replace(R.id.container, moreFragment)
                    return@setOnNavigationItemSelectedListener true
                }
            }
            return@setOnNavigationItemSelectedListener false
        }
    }
}