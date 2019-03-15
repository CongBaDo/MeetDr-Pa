package com.viiam.mvvp.model.metadata

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Language (

    @SerializedName("created_at")
    @Expose
    val createdAt: String,
    @SerializedName("href")
    @Expose
    val href: String,
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("name")
    @Expose
    val name: String

)