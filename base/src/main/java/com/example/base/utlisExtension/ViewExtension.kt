package com.example.base.utlisExtension

import android.content.res.ColorStateList
import android.graphics.Point
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 18/05/2024
 */

fun View.visible(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}

fun View.focus(isFocus: Boolean) {
    if (isFocus) requestFocus() else clearFocus()
}

fun View.invisible(isInvisible: Boolean) {
    visibility = if (isInvisible) View.INVISIBLE else View.VISIBLE
}

fun View.enabled(enabled: Boolean) {
    isEnabled = enabled
}

fun View.alpha(alpha:Float) {
    this.alpha = alpha
}

fun View.setBackground(drawable: Drawable, states:Array<IntArray>?, colors:IntArray?){
    background = drawable
    backgroundTintList = ColorStateList(states,colors)
}

fun View.setMargins(l: Int, t: Int, r: Int, b: Int) {
    if (layoutParams is ViewGroup.MarginLayoutParams) {
        val p: ViewGroup.MarginLayoutParams = layoutParams as ViewGroup.MarginLayoutParams
        p.setMargins(l, t, r, b)
        requestLayout()
    }
}

fun View.getStatusBarHeight():Int = context.getStatusBarHeight()


fun View.getLocationOnScreen(): Point {
    val location = IntArray(2)
    this.getLocationOnScreen(location)
    return Point(location[0],location[1])
}

fun View.translateView(translation:Float){
    animate().translationY(translation).setDuration(100).start()
}