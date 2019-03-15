package com.viiam.mvvp.model.metadata

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Gender (

    @SerializedName("code")
    @Expose
    val code: String,
    @SerializedName("name")
    @Expose
    val name: String

)



