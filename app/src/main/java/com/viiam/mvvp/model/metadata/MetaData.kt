package com.viiam.mvvp.model.metadata

import androidx.lifecycle.LiveData
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MetaData(

        @SerializedName("contact_frequencies")
        @Expose
        val contactFrequencies: List<ContactFrequency>,
        @SerializedName("contact_methods")
        @Expose
        val contactMethods: List<ContactMethod>,
        @SerializedName("countries")
        @Expose
        val countries: List<Country>,
        @SerializedName("ethnicities")
        @Expose
        val ethnicities: List<Ethnicity>,
        @SerializedName("genders")
        @Expose
        val genders: LiveData<List<Gender>>,
        @SerializedName("languages")
        @Expose
        val languages: List<Language>,
        @SerializedName("percentage")
        @Expose
        val percentage: Percentage,
        @SerializedName("religions")
        @Expose
        val religions: List<Religion>,
        @SerializedName("specialties")
        @Expose
        val specialties: LiveData<List<Specialty>>

)

