package com.samuvel.pandian.seithigal.entities

data class News(
    var status: String?,
    var totalResults: Int?,
    var articles: ArrayList<Article>
)