package com.nery.lbustos.mymovies

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nery.lbustos.mymovies.databinding.ItemMovieBinding

class ViewHolderMovie(itemView: View) : RecyclerView.ViewHolder(itemView) {


    private var binding: ItemMovieBinding = ItemMovieBinding.bind(itemView)


    fun bind(movieItem: MovieItem,listener: (MovieItem) -> Unit){

        val url = String.format("%s%s",
            "https://image.tmdb.org/t/p/w500/",movieItem.poster)
        Glide.with(itemView.context).load(url).into(binding.imgViewPoster)
        binding.imgViewPoster.setOnClickListener{
            listener(movieItem)
        }

    }


}