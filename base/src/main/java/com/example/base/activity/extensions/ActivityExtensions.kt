package com.example.base.activity.extensions

import android.app.Activity
import android.content.Intent
import androidx.annotation.AnimRes
import androidx.core.app.ActivityOptionsCompat.makeCustomAnimation

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 25/04/2024
 */


/**
 *  Start New Activity without animation
 *  @param activity the destination class name
 */

fun <A: Activity> Activity.startActivity(activity: Class<A>){
    Intent(this,activity).also {
        this.startActivity(it)
    }
}

/**
 *  Start Activity with Animation
 *  @param activity the class name
 *  @param startAnim
 *  @param endEnim
 */

fun <A : Activity> Activity.startNewActivityWithAnimation(activity: Class<A>, @AnimRes startAnim:Int, @AnimRes endAnim :Int){

      Intent(this, activity).also {
          it.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
          this.startActivity(it)
          makeCustomAnimation(this,startAnim,endAnim)

          this.finish()


      }
}
