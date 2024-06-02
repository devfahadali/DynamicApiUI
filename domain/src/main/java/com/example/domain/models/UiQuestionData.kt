package com.example.domain.models

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 17/05/2024
 */
// models/QuestionData.kt
data class UiQuestionData(
    val questionText: String="",
    val sectionTitle: String="",
    val message: String="",
    val questionTextSectionField:String="",
    val options: List<String> = emptyList()
)