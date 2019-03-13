package com.viiam.mvvp.model.metadata

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Specialty (

    @SerializedName("active")
    @Expose
    val active: Boolean,
    @SerializedName("description")
    @Expose
    val description: String,
    @SerializedName("display_order")
    @Expose
    val displayOrder: Int,
    @SerializedName("group_id")
    @Expose
    val groupId: Int,
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("name")
    @Expose
    val name: String

)

