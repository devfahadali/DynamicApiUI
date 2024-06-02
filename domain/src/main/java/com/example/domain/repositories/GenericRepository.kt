package com.example.domain.repositories

import com.example.domain.models.UiQuestionData

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 17/05/2024
 */

interface GenericRepository {

    suspend fun getGenericListM(formId:Int,customerId:Int,section:Int) : List<UiQuestionData>

}