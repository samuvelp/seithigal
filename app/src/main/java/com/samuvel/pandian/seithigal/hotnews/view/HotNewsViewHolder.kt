package com.samuvel.pandian.seithigal.hotnews.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.hot_news_row.view.*

class HotNewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvTitle = itemView.title
    val tvDescription = itemView.description
    val tvAuthor = itemView.author
    val tvPublishedAt = itemView.published_at
    val imageView = itemView.image_view
}