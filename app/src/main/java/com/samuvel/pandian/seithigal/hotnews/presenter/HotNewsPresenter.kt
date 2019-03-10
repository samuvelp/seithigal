package com.samuvel.pandian.seithigal.hotnews.presenter

import com.samuvel.pandian.seithigal.entities.News
import com.samuvel.pandian.seithigal.hotnews.model.HotNewsModel
import com.samuvel.pandian.seithigal.hotnews.model.HotNewsModelInteractor
import com.samuvel.pandian.seithigal.hotnews.view.HotNewsViewInteractor

class HotNewsPresenter : HotNewsPresenterInteractor {
    private var hotNewsModel: HotNewsModelInteractor = HotNewsModel()
    private var view: HotNewsViewInteractor? = null

    override fun attachView(view: HotNewsViewInteractor) {
        this.view = view
        hotNewsModel.attachPresenter(this)
    }

    override fun detachView() {
        this.view = null
        hotNewsModel.detachPresenter()
    }

    override fun getHotNews() {
        view?.showProgress()
        hotNewsModel.getHotNews()
    }

    override fun onHotNewsSuccess(news: News) {
        view?.hideProgress()
        view?.populateList(news)
    }

    override fun onHotNewsFailed() {
        view?.failedToGetResult()
    }
}