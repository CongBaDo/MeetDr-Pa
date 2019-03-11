package com.viiam.mvvp.splashScreen

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Start home activity
        startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
        // close splash activity
        finish()
    }
}