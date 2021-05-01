package com.sgemin.daggertwoex.webutils.dto

import com.google.gson.annotations.SerializedName

/**
 * Created by Stephen Gemin on 9/1/2019
 */
class StarWars {

    @SerializedName("results")
    var results: List<People>? = null

    inner class People {
        @SerializedName("name") var name: String? = null
        @SerializedName("height") var height: String? = null
        @SerializedName("mass") var mass: String? = null
        @SerializedName("birth_year") var birthYear: String? = null
        @SerializedName("gender") var gender: String? = null
        @SerializedName("homeworld") var homeworld: String? = null
        @SerializedName("films") var films: List<String>? = null
    }
}
