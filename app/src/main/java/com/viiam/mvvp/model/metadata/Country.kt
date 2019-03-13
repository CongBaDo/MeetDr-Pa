package com.viiam.mvvp.model.metadata

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Country (
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("iso")
    @Expose
    val iso: String,
    @SerializedName("iso_name")
    @Expose
    val isoName: String,
    @SerializedName("iso3")
    @Expose
    val iso3: String,
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("numcode")
    @Expose
    val numcode: Int,
    @SerializedName("states")
    @Expose
    val states: List<State>,
    @SerializedName("states_required")
    @Expose
    val statesRequired: Boolean
)