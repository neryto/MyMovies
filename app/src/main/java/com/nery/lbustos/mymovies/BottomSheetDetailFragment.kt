package com.nery.lbustos.mymovies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetDetailFragment(val movieItem: MovieItem) : BottomSheetDialogFragment() {


    var textViewTitle : TextView? = null
    var textViewOverview : TextView? = null
    var imgView : ImageView ? = null
    var imageViewClose : ImageView? = null

    companion object {

        const val TAG = "BottomSheetDialogFragment"

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.modal_bottom_sheet,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textViewTitle = view.findViewById(R.id.tvTitle)
        textViewOverview = view.findViewById(R.id.tvOverview)
        imgView = view.findViewById(R.id.imgViewPosterDetail)
        imageViewClose = view.findViewById(R.id.btnClose)
    }

    fun initView(){
        textViewTitle?.text = movieItem.title
        textViewOverview?.text = movieItem.overview
        val url = String.format("%s%s",
            "https://image.tmdb.org/t/p/w500/",movieItem.poster)
        Glide.with(this).load(url).into(imgView!!)
        imageViewClose?.setOnClickListener{
            this.dismiss()
        }
    }


}