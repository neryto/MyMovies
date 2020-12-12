package com.nery.lbustos.mymovies

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesWebservices {

    @GET("3/movie/popular")
    fun getMovies(@Query("api_key") apiKey : String) : Call<MoviesResponse>
}