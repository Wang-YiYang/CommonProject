package com.yiang.common

import android.app.Application
import me.yiang.common.ContextManager

/**
 *创建：yiang
 * <p>
 *描述：
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        ContextManager.init(this.applicationContext)
    }
}