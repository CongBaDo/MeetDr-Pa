package com.viiam.mvvp.model.metadata

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MetadataResponse (
        @SerializedName("data")
        @Expose
        val data: MetaData,
        @SerializedName("error")
        @Expose
        val error: Int,
        @SerializedName("message")
        @Expose
        val message: String
)