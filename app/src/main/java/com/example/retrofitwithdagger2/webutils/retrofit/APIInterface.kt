package com.sgemin.daggertwoex.webutils.retrofit

import com.sgemin.daggertwoex.webutils.dto.Film
import com.sgemin.daggertwoex.webutils.dto.StarWars
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

/**
 * Created by Stephen Gemin on 8/31/2019
 */
interface APIInterface {

    @GET("people/?")
    fun getPeople(@Query("format") format: String): Call<StarWars>

    @GET
    fun getFilmData(
        @Url url: String,
        @Query("format") format: String): Call<Film>
}