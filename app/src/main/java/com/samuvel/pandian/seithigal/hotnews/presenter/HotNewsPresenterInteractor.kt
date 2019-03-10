package com.samuvel.pandian.seithigal.hotnews.presenter

import com.samuvel.pandian.seithigal.entities.News
import com.samuvel.pandian.seithigal.hotnews.view.HotNewsViewInteractor

interface HotNewsPresenterInteractor{
    fun getHotNews()
    fun onHotNewsSuccess(news: News)
    fun onHotNewsFailed()
    fun attachView(view: HotNewsViewInteractor)
    fun detachView()
}