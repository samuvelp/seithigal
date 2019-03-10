package com.samuvel.pandian.seithigal.hotnews.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.samuvel.pandian.seithigal.R
import com.samuvel.pandian.seithigal.entities.Articles
import com.samuvel.pandian.seithigal.entities.News
import com.samuvel.pandian.seithigal.hotnews.presenter.HotNewsPresenter
import com.samuvel.pandian.seithigal.hotnews.presenter.HotNewsPresenterInteractor
import kotlinx.android.synthetic.main.fragment_hot_news.*

class HotNewsFragment : Fragment(), HotNewsViewInteractor {
    lateinit var mHotNewsRecyclerView: RecyclerView
    lateinit var mHotNewsProgressBar: ProgressBar
    lateinit var mHotNewsErrorTextView: TextView
    var articles: ArrayList<Articles>? = null
    var mHotNewsPresenter: HotNewsPresenterInteractor = HotNewsPresenter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val hotNewsView: View = inflater.inflate(R.layout.fragment_hot_news, container, false)
        init(hotNewsView)
        mHotNewsPresenter.attachView(this)
        mHotNewsPresenter.getHotNews()
        return hotNewsView
    }

    fun init(view: View) {
        mHotNewsRecyclerView = view.findViewById(R.id.hotNewsRecyclerView)
        mHotNewsProgressBar = view.findViewById(R.id.hotNewsProgressBar)
        mHotNewsErrorTextView = view.findViewById(R.id.hotNewsErrorTextView)
    }

    override fun onDetach() {
        super.onDetach()
        mHotNewsPresenter.detachView()
    }

    override fun showProgress() {
        mHotNewsProgressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        mHotNewsProgressBar.visibility = View.GONE
    }

    override fun populateList(news: News) {
        Log.d("HOTNEWS", "" + news.totalResults)
        hotNewsRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = HotNewsAdapter(news.articles, context)
        }
    }

    override fun failedToGetResult() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        @JvmStatic
        fun newInstance() = HotNewsFragment()
    }
}
