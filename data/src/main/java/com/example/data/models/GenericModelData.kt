package com.example.data.models

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 17/05/2024
 */
data class GenericModelData (
    val error: Boolean,
    val currentSection: Long,
    val nextSection: Any? = null,
    val totalSection: Long,
    val result: Result,
    val message: String,
    val statusCode: Long
)

data class Result (
    val id: Long,
    val title: String,
    val formName: String,
    val published: Boolean,
    val createdDate: String,
    val updatedDate: String,
    val version: Long,
    val currentSection: CurrentSection,
    val totalSections: List<TotalSection>
)

data class CurrentSection (
    val id: Long,
    val sectionTitle: String,
    val position: Long,
    val questions: List<QuestionElement>
)

data class QuestionElement (
    val question: QuestionQuestion,
    val position: Long,
    val required: Boolean
)

data class Child (
    val id: Long,
    val section: Long,
    val question: QuestionQuestion,
    val choice: Long
)

data class Option (
    val id: Long,
    val dropdownQuestion: Long,
    val choiceText: String,
    val childs: List<Child>,
    val haschild: Boolean
)

data class ContentObject (
    val id: Long,
    val options: List<Option>,
    val answers: String,
    val questionText: String,
    val questionType: String,
    val regex: String,
    val hasOption: Boolean
)

data class QuestionQuestion (
    val id: Long,
    val contentType: String,
    val contentObject: ContentObject,
    val answers: String,
    val objectID: Long,
    val createdDate: String,
    val updatedDate: String,
    val enabled: Boolean,
    val version: Long,
    val published: Boolean
)

data class TotalSection (
    val id: Long,
    val sectionTitle: String,
    val position: Long,
    val status: String,
    val isCompleted: Boolean
)