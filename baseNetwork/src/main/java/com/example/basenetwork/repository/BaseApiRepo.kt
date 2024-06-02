package com.example.basenetwork.repository


import com.example.basenetwork.response.BaseNetworkResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 26/04/2024
 */
abstract class BaseApiRepo {
    suspend fun <T> apiCall(apiCall: suspend ()-> T): BaseNetworkResponse<T>{

        return  withContext(Dispatchers.IO){
            try {
                BaseNetworkResponse.Success(apiCall.invoke())
            }catch (exception:Exception){
                when(exception){
                    is retrofit2.HttpException ->{
                        BaseNetworkResponse.Failure(exception, exception.message,exception.code())
                    }
                    else ->{
                        BaseNetworkResponse.Failure(exception,exception.message,null)
                    }
                }

            }
        }
    }
}