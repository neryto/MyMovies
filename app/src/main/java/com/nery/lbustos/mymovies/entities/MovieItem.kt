package com.nery.lbustos.mymovies.entities

import com.google.gson.annotations.SerializedName

data class MovieItem(val id:Int,
                     @SerializedName("original_title")
                     val title : String,
                     val overview : String,
                     @SerializedName("vote_average")
                     val rate : Double,
                     @SerializedName("poster_path")
                     val poster : String)