package com.viiam.mvvp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import com.google.gson.Gson
import com.horus.edc.utils.PreferenceUtils
import com.viiam.mvvp.model.Post
import com.viiam.mvvp.model.metadata.Gender
import com.viiam.mvvp.model.metadata.MetaData
import com.viiam.mvvp.model.metadata.MetadataResponse
import io.reactivex.android.schedulers.AndroidSchedulers.*
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import com.viiam.mvvp.preference.PrefConstant

class SplashReposity(application: Application) : BaseReposity(application) {

    private var TAG: String = "SplashReposity"

    private var subscription: Disposable? = null

    init {
        var metaDataString  = PreferenceUtils.getStringPref(application, PrefConstant.PREF_METADATA, "")
    }

    fun getMetadata() {

        subscription = postApi
                .getMetadata()
                .observeOn(mainThread())
                .subscribeOn(Schedulers.io())
                .doOnTerminate { Log.e(TAG, "onTerminate ") }
                .subscribe(
                        { metadataResponse ->
                            PreferenceUtils.saveStringPref(application, PrefConstant.PREF_METADATA, Gson().toJson(metadataResponse.data))
                        },
                        { error ->
                            error.message
                            Log.e(TAG, "Message Err " + error.message)
                        }
                )
    }
}