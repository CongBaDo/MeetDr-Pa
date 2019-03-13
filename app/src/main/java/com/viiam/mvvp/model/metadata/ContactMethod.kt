package com.viiam.mvvp.model.metadata

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ContactMethod (

    @SerializedName("code")
    @Expose
    val code: String,
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("name")
    @Expose
    val name: String
)
