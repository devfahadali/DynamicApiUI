package com.example.data.api

import com.example.data.Generic_Forms
import com.example.data.models.GenericModelData
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import java.io.File

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 17/05/2024
 */

interface GenericApi {

    @GET(Generic_Forms)
    suspend fun getGenericForms(
        @Query("formId") formId: Int,
        @Query("customerId") customerId: Int,
        @Query("section") section: Int
    ): Response<GenericModelData>

}