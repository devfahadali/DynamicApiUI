package com.example.base.fragment.extension

import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.fragment.app.Fragment

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 26/04/2024
 */

fun <A : Activity> Fragment.startNewActivity(activity: Class<A>) {
    Intent(requireActivity(), activity).also {
        this.startActivity(it)
    }
}

fun Fragment.addChildFragmentToView(container: View, fragment: Fragment) {

    childFragmentManager.beginTransaction().replace(container.id, fragment).addToBackStack(null)
        .commit()
}

fun Fragment.removeChildFragment(fragment: Fragment){
    childFragmentManager.beginTransaction().remove(fragment).commit()
}