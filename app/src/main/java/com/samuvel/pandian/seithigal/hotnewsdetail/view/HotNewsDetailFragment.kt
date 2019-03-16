package com.samuvel.pandian.seithigal.hotnewsdetail.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.facebook.drawee.view.SimpleDraweeView
import com.samuvel.pandian.seithigal.R
import com.samuvel.pandian.seithigal.entities.Article

class HotNewsDetailFragment : Fragment() {
    lateinit var mDetailImageView: SimpleDraweeView
    lateinit var mDetailTimeStamp: TextView
    lateinit var mDetailTitle: TextView
    lateinit var mDetailContent: TextView
    lateinit var mArticle: Article
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var article: Article = activity?.intent?.getParcelableExtra("article") as Article
        val view = inflater.inflate(R.layout.fragment_hot_news_detail, container, false)
        initViews(view)
        setData(article)
        return view
    }

    fun initViews(view: View) {
        mDetailImageView = view.findViewById(R.id.detail_image_view)
        mDetailTitle = view.findViewById(R.id.detail_title)
        mDetailTimeStamp = view.findViewById(R.id.detail_timestamp)
        mDetailContent = view.findViewById(R.id.detail_content)
    }
    fun setData(article: Article){
        mDetailTitle.text = article.title
        mDetailTimeStamp.text = article.publishedAt
        mDetailContent.text = article.content
    }
    companion object {
        @JvmStatic
        fun newInstance() =
            HotNewsDetailFragment()
    }
}
