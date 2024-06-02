package com.example.base.utlisExtension

import android.graphics.Color
import android.graphics.drawable.GradientDrawable

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 18/05/2024
 */
fun getDrawable(
    color: Int,
    borderColor: Int = Color.TRANSPARENT,
    borderWidth: Int = 0,
    topLeft: Float = 0f,
    topRight: Float = 0f,
    bottomRight: Float = 0f,
    bottomLeft: Float = 0f
): GradientDrawable =
    GradientDrawable().also {
        it.setColor(color)
        it.setStroke(borderWidth.dp, borderColor)
        it.cornerRadii = floatArrayOf(
            topLeft,
            topLeft,
            topRight,
            topRight,
            bottomRight,
            bottomRight,
            bottomLeft,
            bottomLeft
        )
    }

fun getFilledDrawable(
    color: Int,
    radius:  Float = 0f
): GradientDrawable = getDrawable(
    color,
    topLeft = radius,
    topRight = radius,
    bottomRight = radius,
    bottomLeft = radius
)
fun getFilledDrawableTopBottom(
    color: Int,
    radius:  Float = 0f
): GradientDrawable = getDrawable(
    color,
    topLeft = 0f,
    topRight = radius,
    bottomRight = radius,
    bottomLeft = 0f
)

fun getFilledDrawableTopLeftRight(
    color: Int,
    radius:  Float = 0f
): GradientDrawable = getDrawable(
    color,
    topLeft = radius,
    topRight = radius,
    bottomRight = 0f,
    bottomLeft = 0f
)
fun getBorderedDrawable(
    borderColor: Int,
    borderWidth: Int = 1,
    fillColor: Int = Color.WHITE,
    radius: Float = 0f
): GradientDrawable = getDrawable(
    fillColor,
    borderColor,
    borderWidth,
    radius,
    topRight = radius,
    bottomRight = radius,
    bottomLeft = radius
)