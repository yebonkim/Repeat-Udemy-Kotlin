package com.example.yebon.repeatudemykotlin.chapter1.util

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.yebon.repeatudemykotlin.R

class Utils {
    companion object {
        val KEY_TITLE = "title"
    }
}

fun AppCompatActivity.replace (@IdRes id: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(id, fragment).commit()
}