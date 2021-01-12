package com.nery.lbustos.mymovies.networkplatform.responses

import com.google.gson.annotations.SerializedName
import com.nery.lbustos.mymovies.entities.MovieItem

class MoviesResponse {
    val page : Int = 0
    @SerializedName("total_pages")
    val totalPAges : Int = 0
    @SerializedName("total_results")
    val totalResults : Int = 0
    val results : List<MovieItem> = arrayListOf()



}