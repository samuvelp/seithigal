package com.samuvel.pandian.seithigal.hotnews.model

import com.samuvel.pandian.seithigal.api.RetrofitHelper
import com.samuvel.pandian.seithigal.entities.News
import com.samuvel.pandian.seithigal.hotnews.presenter.HotNewsPresenterInteractor

class HotNewsModel : HotNewsModelInteractor, RetrofitHelper.RetrofitHelperListener {
    private var mPresenter: HotNewsPresenterInteractor? = null

    override fun attachPresenter(presenter: HotNewsPresenterInteractor) {
        this.mPresenter = presenter
    }

    override fun detachPresenter() {
        this.mPresenter = null
    }

    override fun getHotNews() {
        val retrofitHelper = RetrofitHelper(this)
        retrofitHelper.getHotNews()
    }

    override fun onHotNewsFetchFailure() {
        mPresenter?.onHotNewsFailed()
    }

    override fun onHotNewsFetchSuccess(result: News) {
        mPresenter?.onHotNewsSuccess(result)
    }

}