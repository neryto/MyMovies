package com.nery.lbustos.mymovies.movies.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nery.lbustos.mymovies.R
import com.nery.lbustos.mymovies.entities.MovieItem

class MovieAdapter (private val movies : List<MovieItem>, private val listener : (MovieItem)->Unit)
    : RecyclerView.Adapter<ViewHolderMovie>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMovie {
        val view : View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_movie,parent,false)
        return ViewHolderMovie(view)
    }

    override fun getItemCount(): Int {
       return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolderMovie, position: Int) {
       holder.bind(movies[position],listener)
    }

}