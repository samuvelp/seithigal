package com.samuvel.pandian.seithigal.hotnews.model

import com.samuvel.pandian.seithigal.hotnews.presenter.HotNewsPresenterInteractor


interface HotNewsModelInteractor {
    fun getHotNews()
    fun attachPresenter(presenter : HotNewsPresenterInteractor)
    fun detachPresenter()
}