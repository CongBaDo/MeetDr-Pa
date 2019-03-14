package com.viiam.mvvp.activity.splashactivity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import com.viiam.mvvp.R
import com.viiam.mvvp.activity.guideactivity.GuideActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var firstTimeUseApp = true
        if (firstTimeUseApp)
            startActivity(Intent(this, GuideActivity::class.java))
        else
            Toast.makeText(applicationContext, "NOT FIRST TIME USE APP --> NO GUIDE SCREEN",Toast.LENGTH_LONG)
        finish()
    }
}