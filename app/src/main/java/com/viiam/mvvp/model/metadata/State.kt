package com.viiam.mvvp.model.metadata

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class State(

    @SerializedName("abbr")
    @Expose
    val abbr: String,
    @SerializedName("id")
    @Expose
    val id: String,
    @SerializedName("name")
    @Expose
    val name: String

)
