package com.example.base.adapter.listeners

import android.view.View

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 26/04/2024
 */

fun interface  OnItemClickedListeners<T>{
    fun  onItemClicked(media:T, position: Int)
}

fun interface  ItemClickListenerImage<T>{
    fun onClick(view: View, position: Int, media:T)
}
fun interface  ItemClickListener<T>{
    fun onClick(position: Int, media:T)
}

fun interface ItemClickCheckView<T>{
    fun onClick(checkView: String, position: Int, media:T)
}
