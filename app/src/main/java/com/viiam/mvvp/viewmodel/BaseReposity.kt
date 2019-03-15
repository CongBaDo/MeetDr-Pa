package com.viiam.mvvp.viewmodel

import android.app.Application
import com.viiam.mvvp.DaggerNemoInjector
import com.viiam.mvvp.NemoInjector
import com.viiam.mvvp.module.ContextModule
import com.viiam.mvvp.module.NetworkModule
import com.viiam.mvvp.network.PostApi
import javax.inject.Inject

abstract class BaseReposity(application: Application) {

    var application: Application = application;
    @Inject
    lateinit var postApi: PostApi

    //    /**
//    * The inhector used to inject required dependencies
//    */
    private val injector: NemoInjector = DaggerNemoInjector.builder()
            .contextModule(ContextModule)
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    fun inject(){
        when(this){
            is PostReposity -> injector.inject(this)
            is SplashReposity -> injector.inject(this);
        }
    }
}