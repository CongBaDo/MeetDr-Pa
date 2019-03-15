package com.viiam.mvvp.splashScreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.viiam.mvvp.activity.PostActivity
import com.viiam.mvvp.viewmodel.MetaDataViewModel

class SplashActivity : AppCompatActivity()  {
    companion object {
        const val prefName="metadata"
        const val prefMode=0
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Start home activity
        startActivity(Intent(this@SplashActivity, PostActivity::class.java))
        finish()

        var metaDataModel = ViewModelProviders.of(this).get(MetaDataViewModel::class.java)
        metaDataModel.getMetaDataRequest()
    }
}