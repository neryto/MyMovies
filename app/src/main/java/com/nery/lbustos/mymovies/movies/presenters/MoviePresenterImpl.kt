package com.nery.lbustos.mymovies.movies.presenters

import com.nery.lbustos.mymovies.entities.MovieItem
import com.nery.lbustos.mymovies.movies.interactors.MovieInteractorImpl
import com.nery.lbustos.mymovies.movies.interfaces.MovieInteractor
import com.nery.lbustos.mymovies.movies.interfaces.MoviePresenter
import com.nery.lbustos.mymovies.movies.interfaces.MovieView
import com.nery.lbustos.mymovies.movies.interfaces.OnMoviesFinishListener

class MoviePresenterImpl (private val view :  MovieView?) : MoviePresenter , OnMoviesFinishListener {

    private val  interactor : MovieInteractor

    init {
        interactor = MovieInteractorImpl()
    }

    override fun getMovies() {
        showShimmer()
        interactor.getMovies(this)
    }

    override fun showShimmer() {
        view?.showShimmer()
    }

    override fun hideShimmer() {
        view?.hideShimmer()
    }

    override fun successGetMovies(movies: List<MovieItem>) {
        hideShimmer()
        view?.successGetMovies(movies)
    }

    override fun errorGetMovies(message:String) {
        hideShimmer()
        view?.errorGetMovies(message)

    }
}