package com.nery.lbustos.mymovies.movies.interfaces

import com.nery.lbustos.mymovies.entities.MovieItem

interface OnMoviesFinishListener {

    fun showShimmer()
    fun hideShimmer()
    fun successGetMovies(movies: List<MovieItem>)
    fun errorGetMovies(message:String)

}