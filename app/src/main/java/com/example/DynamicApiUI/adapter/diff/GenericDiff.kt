package com.example.DynamicApiUI.adapter.diff

import com.example.base.adapter.diffutil.BaseDiffUtil
import com.example.domain.models.UiQuestionData

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 18/05/2024
 */
class GenericDiff:BaseDiffUtil<UiQuestionData>() {
    override fun areContentsTheSame(oldItem: UiQuestionData, newItem: UiQuestionData): Boolean {
      return  oldItem==newItem
    }
}