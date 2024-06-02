package com.example.DynamicApiUI.app

import android.app.Application
import com.example.data.injection.apiInjection
import com.example.DynamicApiUI.injection.viewModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 17/05/2024
 */

class BaseApplication :Application() {

    private val dependencyModules = mutableListOf<Module>()
    override fun onCreate() {
        super.onCreate()
        addKoinModules()
        startKoin {
            androidContext(applicationContext)
            modules(dependencyModules)
        }
    }

    private fun addKoinModules() {

        dependencyModules.add(viewModule)

        dependencyModules.add(apiInjection)

    }
}