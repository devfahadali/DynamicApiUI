package com.example.data.injection

import com.example.basenetwork.config.configure
import com.example.data.BASE_URL
import com.example.data.api.GenericApi
import com.example.data.repos.GenericRepoImpl
import com.example.domain.repositories.GenericRepository
import org.koin.dsl.module

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 17/05/2024
 */

val apiInjection =  module{

    single {
        configure(GenericApi::class.java, BASE_URL)
    }

    single<GenericRepository> {
        GenericRepoImpl(get())
    }

}