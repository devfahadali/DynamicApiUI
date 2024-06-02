package com.example.DynamicApiUI.injection

import com.example.DynamicApiUI.viewmodel.GenericViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 17/05/2024
 */

val viewModule = module {

    viewModel {
        GenericViewModel(get())
    }

}