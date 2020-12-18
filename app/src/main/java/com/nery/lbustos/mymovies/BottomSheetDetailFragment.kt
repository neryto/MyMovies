package com.nery.lbustos.mymovies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.nery.lbustos.mymovies.databinding.ModalBottomSheetBinding

class BottomSheetDetailFragment(val movieItem: MovieItem) : BottomSheetDialogFragment() {

    private lateinit var binding: ModalBottomSheetBinding

    companion object {

        const val TAG = "BottomSheetDialogFragment"

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ModalBottomSheetBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
    }


    fun initView() {
        binding.tvTitle.text = movieItem.title
        binding.tvOverview.text = movieItem.overview
        val url = String.format(
            "%s%s",
            "https://image.tmdb.org/t/p/w500/", movieItem.poster
        )
        Glide.with(this).load(url).into(binding.imgViewPosterDetail)
        binding.imgViewPosterDetail.setOnClickListener {
            this.dismiss()
        }
    }


}