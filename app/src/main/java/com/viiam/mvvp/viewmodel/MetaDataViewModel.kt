package com.viiam.mvvp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel


class MetaDataViewModel(application: Application) : AndroidViewModel(application){

    private var splashRepository: SplashReposity

    init {
        splashRepository = SplashReposity(application)
    }

    fun getMetaDataRequest(){
        splashRepository.getMetadata()
    }
}