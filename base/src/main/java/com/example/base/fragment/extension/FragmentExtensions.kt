package com.example.base.fragment.extension

import androidx.annotation.DimenRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 26/04/2024
 */


fun Fragment.getDimension(@DimenRes id:Int): Float = requireActivity().resources.getDimension(id)

fun Fragment.navigate(navDirection: NavDirections){
    findNavController().navigate(navDirection)
}

fun Fragment.getManager() = requireActivity().supportFragmentManager