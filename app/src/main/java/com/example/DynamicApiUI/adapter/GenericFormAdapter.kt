package com.example.DynamicApiUI.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.base.adapter.BaseListAdapter
import com.example.domain.models.UiQuestionData
import com.example.DynamicApiUI.adapter.diff.GenericDiff
import com.example.DynamicApiUI.adapter.viewholder.GenericFromViewHolder
import com.example.DynamicApiUI.databinding.LayoutTextviewAndSpinnerBinding

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 18/05/2024
 */
class GenericFormAdapter :BaseListAdapter<UiQuestionData,GenericDiff>(GenericDiff()) {
    override fun onViewHolderCreate(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =GenericFromViewHolder(
        LayoutTextviewAndSpinnerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    )

    override fun onViewHolderBind(holder: RecyclerView.ViewHolder, position: Int) = (holder as GenericFromViewHolder).bind(getItem(position),position)
}