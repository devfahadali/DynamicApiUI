package com.example.base.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewbinding.ViewBinding

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 26/04/2024
 */
abstract class BaseViewHolder<B:ViewBinding, T>(binding: B):ViewHolder(binding.root) {
   abstract fun bind(item:T, position: Int)

}