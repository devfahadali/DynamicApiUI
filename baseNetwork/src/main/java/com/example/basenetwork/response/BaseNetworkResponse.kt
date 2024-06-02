package com.example.basenetwork.response

import java.lang.Exception

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 26/04/2024
 */

sealed class  BaseNetworkResponse<out T>{

    data class Success<out T> (val value:T) :BaseNetworkResponse<T>()

    data class Failure(val exception: Exception?, val message: String?, val code:Int? ): BaseNetworkResponse<Nothing>()


}

fun <T> BaseNetworkResponse<T>.getValueFromResponse():T?{
    return  when(this){
        is BaseNetworkResponse.Success->{
            value
        }
        is BaseNetworkResponse.Failure->{
            null
        }
    }

}