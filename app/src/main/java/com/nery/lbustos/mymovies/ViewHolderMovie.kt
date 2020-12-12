package com.nery.lbustos.mymovies

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ViewHolderMovie(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var imgViewPoster: ImageView? = null
    private var tvTitle: TextView? = null
    private var tvRate: TextView? = null
    private var tvOverview: TextView? = null

    init {
        imgViewPoster = itemView.findViewById(R.id.imgViewPoster)
        tvTitle = itemView.findViewById(R.id.tvTitle)
        tvRate = itemView.findViewById(R.id.tvRate)
        tvOverview = itemView.findViewById(R.id.tvOverview)
    }

    fun bind(movieItem: MovieItem){
        tvTitle?.text = movieItem.title
        tvRate?.text = movieItem.rate.toString()
        tvOverview?.text = movieItem.overview
        val url = String.format("%s%s",
            "https://image.tmdb.org/t/p/w500/",movieItem.poster)
        Glide.with(itemView.context).load(url).into(imgViewPoster!!)
    }


}