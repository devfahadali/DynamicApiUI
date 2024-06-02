package com.example.base.utlisExtension

import android.os.Build
import android.util.DisplayMetrics
import android.view.View
import android.widget.TextView

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 18/05/2024
 */


fun View.setFilledDrawable(color: String, radius:String){
    background= getFilledDrawable(context.getColour(color),context.getDimension(radius))
}


fun View.updateHeight(height: Int){
    val displayMetrics: DisplayMetrics = context.resources.displayMetrics
    val screenHeight = displayMetrics.heightPixels
    val scaleFactor = height.toFloat()/screenHeight.toFloat()
    val params = layoutParams
    params.height = (screenHeight *scaleFactor).toInt()
    layoutParams = params
    requestLayout()
}
fun View.updateHeight(heightFactor: Float, keyboardHeight:Int = 0){
    val displayMetrics: DisplayMetrics = context.resources.displayMetrics
    val screenHeight = displayMetrics.heightPixels
    val desiredHeight = if (keyboardHeight == 0){
        (screenHeight *heightFactor).toInt()
    }else{
        val newHeight = screenHeight - keyboardHeight
        (newHeight *heightFactor).toInt()
    }
    val params = layoutParams
    params.height = desiredHeight
    layoutParams = params
    requestLayout()
}

fun View.updateSize(widthFactor: Float, heightFactor: Float){
    val displayMetrics: DisplayMetrics = context.resources.displayMetrics
    val screenHeight = displayMetrics.heightPixels
    val screenWidth = displayMetrics.widthPixels
    val params = layoutParams
    params.width = (screenWidth *widthFactor).toInt()
    params.height = (screenHeight *heightFactor).toInt()
    layoutParams = params
    requestLayout()
}

fun View.updateSize(width: Int, height: Int, baseWidth: Int = 375, baseHeight: Int = 812){
    val displayMetrics: DisplayMetrics = context.resources.displayMetrics
    val screenWidth = displayMetrics.widthPixels
    val screenHeight = displayMetrics.heightPixels
    val widthFactor = width.toFloat()/baseWidth.toFloat()
    val heightFactor = height.toFloat()/baseHeight.toFloat()
    val params = layoutParams
    params.width = (screenWidth *widthFactor).toInt()
    params.height = (screenHeight *heightFactor).toInt()
    layoutParams = params
    requestLayout()
}




fun View.animateHorizontally(value: Float, duration: Long = 400) {
    animate().translationX(value)
        .setDuration(duration).start()
}

fun TextView.setStyle(id:Int){
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        setTextAppearance(id)
    }else{
        setTextAppearance(context,id)
    }
}
