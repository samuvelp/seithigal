package com.samuvel.pandian.seithigal.hotnews.view

import android.content.Intent
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
import com.facebook.shimmer.ShimmerFrameLayout
import com.samuvel.pandian.seithigal.R
import com.samuvel.pandian.seithigal.activities.HotNewsDetailActivity
import com.samuvel.pandian.seithigal.entities.Article
import com.samuvel.pandian.seithigal.entities.News
import com.samuvel.pandian.seithigal.hotnews.presenter.HotNewsPresenter
import com.samuvel.pandian.seithigal.hotnews.presenter.HotNewsPresenterInteractor
import kotlinx.android.synthetic.main.fragment_hot_news.*

class HotNewsFragment : Fragment(), HotNewsViewInteractor,HotNewsAdapter.ListInteractionListener {
    lateinit var mHotNewsRecyclerView: RecyclerView
    lateinit var mHotNewsProgressBar: ProgressBar
    lateinit var mHotNewsErrorTextView: TextView
    lateinit var mShimmerView: ShimmerFrameLayout
    var articles: ArrayList<Article>? = null
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
        mShimmerView = view.findViewById(R.id.shimmer_view_container)
    }

    override fun onDetach() {
        super.onDetach()
        mHotNewsPresenter.detachView()
    }

    override fun showProgress() {
        mShimmerView.startShimmerAnimation()
    }

    override fun hideProgress() {
        mShimmerView.visibility = View.GONE
    }

    override fun populateList(news: News) {
        Log.d("HOTNEWS", "" + news.totalResults)
        hotNewsRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = HotNewsAdapter(news.articles, context,this@HotNewsFragment)
        }
    }

    override fun failedToGetResult() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemClicked(article: Article) {
        val intent = Intent(activity, HotNewsDetailActivity::class.java)
        intent.putExtra("article",article)
        startActivity(intent)
    }

    companion object {
        @JvmStatic
        fun newInstance() = HotNewsFragment()
    }
}
