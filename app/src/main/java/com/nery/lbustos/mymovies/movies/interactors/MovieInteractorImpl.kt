package com.nery.lbustos.mymovies.movies.interactors

import com.nery.lbustos.mymovies.movies.interfaces.MovieInteractor
import com.nery.lbustos.mymovies.movies.interfaces.OnMoviesFinishListener
import com.nery.lbustos.mymovies.networkplatform.MoviesWebservices
import com.nery.lbustos.mymovies.networkplatform.responses.MoviesResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieInteractorImpl : MovieInteractor {

    override fun getMovies(onMoviesFinishListener: OnMoviesFinishListener) {
        getRetrofit().create(MoviesWebservices::class.java)
            .getMovies("117d1bd56ea2f98e9662d5cfbd5408e2")
            .enqueue(object : Callback<MoviesResponse> {
                override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                    onMoviesFinishListener.errorGetMovies(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<MoviesResponse>,
                    response: Response<MoviesResponse>
                ) {
                    if (response.isSuccessful)
                    onMoviesFinishListener.successGetMovies(response.body()?.results!!)
                    else
                        onMoviesFinishListener.errorGetMovies(response.message())

                }

            })
    }

    private fun getRetrofit(): Retrofit {
        val loggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val httpClientBuilder = OkHttpClient.Builder().addInterceptor(loggingInterceptor!!)
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .client(httpClientBuilder?.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}