package com.example.base.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 26/04/2024
 */

abstract class BaseListAdapter<T, D : DiffUtil.ItemCallback<T>>(util: D) :
    ListAdapter<T, ViewHolder>(util) {
    abstract fun onViewHolderCreate(parent: ViewGroup, viewType: Int): ViewHolder
    abstract fun onViewHolderBind(holder: ViewHolder, position: Int)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        onViewHolderCreate(parent, viewType)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        onViewHolderBind(holder, position)

    override fun getItemViewType(position: Int) = position

}