package com.samuvel.pandian.seithigal.hotnews.view

import com.samuvel.pandian.seithigal.entities.News


interface HotNewsViewInteractor {
    fun showProgress()
    fun hideProgress()
    fun populateList(news: News)
    fun failedToGetResult()
}