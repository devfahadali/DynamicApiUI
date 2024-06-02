package com.example.base.adapter.extension

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.base.adapter.utlis.SpacesItemDecoration

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 26/04/2024
 */

fun RecyclerView.setLayoutManager(): LinearLayoutManager {

    val manager = LinearLayoutManager(context)
     layoutManager = manager
    return manager
}

fun RecyclerView.setHorizontalLayoutManager() {
    this.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
}

fun RecyclerView.setHorizontalLayoutManager(withPercentage: Float, reverse: Boolean) {

    this.layoutManager = object : LinearLayoutManager(context, HORIZONTAL, reverse) {

        override fun checkLayoutParams(lp: RecyclerView.LayoutParams?): Boolean {
            lp?.let {
                it.width = (width * withPercentage).toInt()
            }
            return true
//            return super.checkLayoutParams(lp)
        }
    }
}

fun RecyclerView.setHorizontalLayoutManager(
    withPercentage: Float,
    space: Int = 5,
    reverse: Boolean = false
) {

   val  manager = object : LinearLayoutManager(context, HORIZONTAL, reverse) {
        override fun checkLayoutParams(lp: RecyclerView.LayoutParams?): Boolean {
            lp?.let {
                it.width = (width * withPercentage).toInt()
            }
            return true
        }
    }

    val decoration = SpacesItemDecoration(space)
    this.addItemDecoration(decoration)
    layoutManager=  manager

}

fun RecyclerView.setGridLayoutManager(spanCount:Int= 2, space:Int= 5){
    layoutManager =  GridLayoutManager(context,spanCount)
    val decoration = SpacesItemDecoration(space)

    this.addItemDecoration(decoration)
}

fun RecyclerView.setGridManager(spaceCount: Int= 2, space:Int, orientation:Int = StaggeredGridLayoutManager.VERTICAL): StaggeredGridLayoutManager {

    val manager =  StaggeredGridLayoutManager(spaceCount,orientation)
    val decoration = SpacesItemDecoration(space)
    this.addItemDecoration(decoration)

    layoutManager= manager
    return manager

}