package com.example.DynamicApiUI.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.UiQuestionData
import com.example.domain.repositories.GenericRepository
import kotlinx.coroutines.launch

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 17/05/2024
 */

class GenericViewModel(private val repository: GenericRepository) : ViewModel() {

    private val _genericData: MutableLiveData<List<UiQuestionData>> by lazy {
        MutableLiveData()
    }

    val genericData: LiveData<List<UiQuestionData>>
        get() = _genericData

    fun getProductListM(formId: Int, customerId: Int, section: Int) = viewModelScope.launch {
        _genericData.value = repository.getGenericListM(formId, customerId, section)

    }
}