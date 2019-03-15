package com.viiam.mvvp.splashScreen

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.viiam.mvvp.BASE_URL
import com.viiam.mvvp.activity.PostActivity
import com.viiam.mvvp.global.ShareData
import com.viiam.mvvp.model.metadata.MetaData
import com.viiam.mvvp.network.GetMetadata
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_post.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class SplashActivity : AppCompatActivity() {
    companion object {
        const val prefName="metadata"
        const val prefMode=0
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Start home activity
        startActivity(Intent(this@SplashActivity, PostActivity::class.java))
        initData()
        //close splash activity
        finish()
    }
    fun initData(){
        val sharedPref:SharedPreferences=getSharedPreferences(prefName, prefMode)
        val find=sharedPref.contains(prefName)
        if(!find){
            val retrofit= Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .build()
            val ob=retrofit.create(GetMetadata::class.java)
                    .getMetadata()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe ({
                        val editor=sharedPref.edit()
                        editor.putString(prefName,Gson().toJson(it.data,MetaData::class.java))
                        editor.apply()
                    },{})
        }
    }
}