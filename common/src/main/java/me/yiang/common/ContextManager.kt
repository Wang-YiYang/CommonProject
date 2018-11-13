package me.yiang.common

import android.content.Context

/**
 *创建：yiang
 * <p>
 *描述：
 */
class ContextManager {

    companion object {
        private val configMap = HashMap<String, Any>()

        fun init(context: Context) {
            configMap["context"] = context
        }

        fun getContext(): Context {
            val context = configMap["context"] ?: throw  Throwable("数据未空，common库未在application中初始化。。")
            return configMap["context"] as Context
        }
    }


}