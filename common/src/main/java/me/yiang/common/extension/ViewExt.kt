package me.yiang.common.extension

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager


/**
 *创建：yiang
 * <p>
 *描述：拓展方法
 */

fun Context.screenWidth(): Int = resources.displayMetrics.widthPixels

//fun Context.screenHight(): Int = resources.displayMetrics.heightPixels

/**
 * 网上其他方式并不能获取到准确的高度，通常会少掉状态栏的高度
 */
fun Context.screenHight(): Int {
    val displayMetrics = DisplayMetrics()
    val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val clazz = Class.forName("android.view.Display")
    val method = clazz.getMethod("getRealMetrics", DisplayMetrics::class.java)
    method.invoke(windowManager.defaultDisplay, displayMetrics)
    return displayMetrics.heightPixels
}

fun Context.dip2px(dip: Float): Int = (resources.displayMetrics.density * dip + 0.5f).toInt()

fun Context.px2dip(px: Float): Int = (px / resources.displayMetrics.density + 0.5f).toInt()

fun Context.sp2px(sp: Float): Int = (sp * resources.displayMetrics.density + 0.5f).toInt()

fun Context.px2sp(sp: Float): Int = (sp / resources.displayMetrics.density + 0.5f).toInt()
