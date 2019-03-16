package com.samuvel.pandian.seithigal.hotnews.view

import android.content.Context
import android.net.Uri
import android.net.wifi.p2p.WifiP2pManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import com.samuvel.pandian.seithigal.R
import com.samuvel.pandian.seithigal.entities.Article

class HotNewsAdapter(val articles: ArrayList<Article>, val context: Context, val listListener: ListInteractionListener) :
    RecyclerView.Adapter<HotNewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotNewsViewHolder {
        return HotNewsViewHolder(LayoutInflater.from(context).inflate(R.layout.hot_news_row, parent, false))
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: HotNewsViewHolder, position: Int) {
        holder.tvTitle?.text = articles[position]?.title
        holder.tvDescription?.text = articles[position]?.description
        holder.tvAuthor?.text = articles[position]?.author
        holder.tvPublishedAt?.text = articles[position]?.publishedAt
        setImage(articles[position]?.urlToImage, holder?.imageView)
        holder.itemView.setOnClickListener(View.OnClickListener {
            listListener?.onItemClicked(articles[position])
        })
    }

    private fun setImage(url: String, imageView: SimpleDraweeView) {
        if (url != null) {
            imageView.visibility = View.VISIBLE
            var uri: Uri = Uri.parse(url)
            imageView.setImageURI(uri)
        } else {
            imageView.visibility = View.GONE
        }
    }

    interface ListInteractionListener {
        fun onItemClicked(article: Article)
    }
}