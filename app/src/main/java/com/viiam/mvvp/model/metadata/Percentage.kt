package com.viiam.mvvp.model.metadata

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Percentage (

    @SerializedName("message_rate_percent")
    @Expose
    val messageRatePercent: Int,
    @SerializedName("message_rate_to_coach")
    @Expose
    val messageRateToCoach: Int,
    @SerializedName("session_rate_to_coach")
    @Expose
    val sessionRateToCoach: Int,
    @SerializedName("total_percent")
    @Expose
    val totalPercent: Int
)
