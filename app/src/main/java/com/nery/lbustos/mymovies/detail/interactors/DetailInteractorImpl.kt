package com.nery.lbustos.mymovies.detail.interactors

import com.nery.lbustos.mymovies.detail.interfaces.DetailInteractor
import com.nery.lbustos.mymovies.detail.interfaces.OnShowDetailListener

class DetailInteractorImpl : DetailInteractor {

    override fun showDetail(onShowDetailListener: OnShowDetailListener) {
        onShowDetailListener.showImage()
    }

}