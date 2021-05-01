package com.sgemin.daggertwoex.webutils.dto

import com.google.gson.annotations.SerializedName



/**
 * Created by Stephen Gemin on 8/31/2019
 */
data class Film (
    @SerializedName("title") var title: String? = null,
    @SerializedName("director") var director: String? = null
)