package com.example.data.repos

import com.example.basenetwork.repository.BaseApiRepo
import com.example.basenetwork.response.BaseNetworkResponse
import com.example.data.api.GenericApi
import com.example.domain.models.UiQuestionData
import com.example.domain.repositories.GenericRepository

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 17/05/2024
 */
class GenericRepoImpl(val api: GenericApi) : GenericRepository, BaseApiRepo() {

    override suspend fun getGenericListM(
        formId: Int,
        customerId: Int,
        section: Int
    ): List<UiQuestionData> {

        val response = apiCall {
            api.getGenericForms(formId = formId, customerId = customerId, section = section)
        }
        val listUiQuestionData: MutableList<UiQuestionData> = mutableListOf()
        return when (response) {

            is BaseNetworkResponse.Success -> {

                val listOption: MutableList<String> = mutableListOf()

                var questionTextSectionField = ""

                if (response.value.body()?.result != null) {

                    val sectionTitle = response.value.body()?.result?.currentSection!!.sectionTitle


                    response.value.body()?.result?.currentSection!!.questions.forEachIndexed { index, questionElement ->

                        response.value.body()?.result?.currentSection!!.questions[index].question.contentObject.options.forEachIndexed { index, option ->
                            listOption.add(option.choiceText)
                            option.childs.forEachIndexed { index, child ->
                                questionTextSectionField = child.question.contentObject.questionText
                            }
                        }

                        listUiQuestionData.add(
                            UiQuestionData(
                                questionText = questionElement.question.contentObject.questionText,
                                sectionTitle = sectionTitle,
                                message = "",
                                options = listOf("Select Option") + listOption.toList(),
                                questionTextSectionField = questionTextSectionField
                            )
                        )

                        listOption.clear()
                        questionTextSectionField = ""
                    }

                } else {
                    listUiQuestionData.add(
                        UiQuestionData(
                            message = response.value.body()?.message ?: "",
                        )
                    )
                }

                listUiQuestionData
            }

            is BaseNetworkResponse.Failure -> {
                listUiQuestionData.add(
                    UiQuestionData(
                        message = "Connection Error",
                    )
                )
                listUiQuestionData
            }
        }
    }


}