package com.nery.lbustos.mymovies

import com.google.gson.annotations.SerializedName
import java.lang.StringBuilder

data class MovieItem(val id:Int,
                     @SerializedName("original_title")
                     val title : String,
                     val overview : String,
                     @SerializedName("vote_average")
                     val rate : Double,
                     @SerializedName("poster_path")
                     val poster : String)