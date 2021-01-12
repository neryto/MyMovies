package com.nery.lbustos.mymovies.detail.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.nery.lbustos.mymovies.databinding.ModalBottomSheetBinding
import com.nery.lbustos.mymovies.detail.interfaces.DetailPresenter
import com.nery.lbustos.mymovies.detail.interfaces.DetailView
import com.nery.lbustos.mymovies.detail.presenters.DetailPresenterImpl
import com.nery.lbustos.mymovies.entities.MovieItem

class BottomSheetDetailFragment(private val movieItem: MovieItem) : BottomSheetDialogFragment(),DetailView {

    private lateinit var binding: ModalBottomSheetBinding
    private lateinit var presenter: DetailPresenter


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
        presenter = DetailPresenterImpl(this)
        initView()
    }


    fun initView() {
        binding.tvTitle.text = movieItem.title
        binding.tvOverview.text = movieItem.overview
        binding.imgViewPosterDetail.setOnClickListener {
            this.dismiss()
        }
        presenter.showDetail()
    }

    override fun showImage() {
        val url = String.format(
            "%s%s",
            "https://image.tmdb.org/t/p/w500/", movieItem.poster
        )
        Glide.with(this).load(url).into(binding.imgViewPosterDetail)
    }


}