package com.yiang.common

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import me.yiang.common.extension.screenHight
import me.yiang.common.extension.screenWidth
import me.yiang.common.image.YImageLoader

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        YImageLoader.load("https://goss.veer.com/creative/vcg/veer/800water/veer-133132241.jpg")
                .isCircle().into(image)

        Log.d("main", "宽：${screenWidth()}  高：${screenHight()}")
    }
}
