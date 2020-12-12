package com.nery.lbustos.mymovies

import com.google.gson.annotations.SerializedName

class MoviesResponse {
    val page : Int = 0
    @SerializedName("total_pages")
    val totalPAges : Int = 0
    @SerializedName("total_results")
    val totalResults : Int = 0
    val results : List<MovieItem> = arrayListOf()



}