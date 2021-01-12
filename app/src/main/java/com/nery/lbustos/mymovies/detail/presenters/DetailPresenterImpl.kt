package com.nery.lbustos.mymovies.detail.presenters

import com.nery.lbustos.mymovies.detail.interactors.DetailInteractorImpl
import com.nery.lbustos.mymovies.detail.interfaces.DetailInteractor
import com.nery.lbustos.mymovies.detail.interfaces.DetailPresenter
import com.nery.lbustos.mymovies.detail.interfaces.DetailView
import com.nery.lbustos.mymovies.detail.interfaces.OnShowDetailListener

class DetailPresenterImpl (private val  view: DetailView?) : DetailPresenter  , OnShowDetailListener{


    private val interactor : DetailInteractor

    init {
        interactor = DetailInteractorImpl()
    }

    override fun showDetail() {
        interactor.showDetail(this)
    }


    override fun showImage() {
        view?.showImage()
    }

}