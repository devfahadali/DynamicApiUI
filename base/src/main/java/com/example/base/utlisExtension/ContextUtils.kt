package com.example.base.utlisExtension

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.core.content.ContextCompat

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 18/05/2024
 */
@SuppressLint("DiscouragedApi", "InternalInsetResource")
fun Context.getStatusBarHeight(): Int {
    val statusBarHeightId = resources.getIdentifier("status_bar_height", "dimen", "android")
    return resources.getDimensionPixelSize(statusBarHeightId)
}

@SuppressLint("DiscouragedApi")
fun Context.getResStringId(name: String): Int {
    return resources.getIdentifier(
        name, "string",
        packageName
    )
}

@SuppressLint("DiscouragedApi")
fun Context.getColour(name: String): Int {
    // Get the resource identifier for the color
    val colorResId = resources.getIdentifier(name, "color", packageName)

    // Check if the identifier is valid
    if (colorResId == 0) {
        throw IllegalArgumentException("Color resource not found with name: $name")
    }

    // Return the actual color value using the resource ID
    return ContextCompat.getColor(this, colorResId)
}

//@SuppressLint("DiscouragedApi")
//fun Context.getColour(name: String): Int {
//    return getColour(
//        resources.getIdentifier(
//            name, "color",
//            packageName
//        )
//    )
//}

@SuppressLint("DiscouragedApi")
fun Context.getString(name: String): String {
    return getString(
        resources.getIdentifier(
            name, "string",
            packageName
        )
    )
}

@SuppressLint("DiscouragedApi")
fun Context.getDimension(name: String): Float {
    return resources.getDimension(
        resources.getIdentifier(
            name, "dimen",
            packageName
        )
    )
}

@SuppressLint("DiscouragedApi")
fun Context.getIntArray(name: String): IntArray {
    return resources.getIntArray(
        resources.getIdentifier(
            name, "array",
            packageName
        )
    )
}


fun Context.showToast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Context.getRawUri(fileName:String): Uri {
    return  Uri.parse("android.resource://$packageName/raw/$fileName");
}

fun Context.openBrowser(url: String) {
    val i = Intent(Intent.ACTION_VIEW)
    i.data = Uri.parse(url)
    startActivity(i)
}