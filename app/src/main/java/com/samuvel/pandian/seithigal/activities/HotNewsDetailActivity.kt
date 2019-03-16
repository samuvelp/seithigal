package com.samuvel.pandian.seithigal.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.samuvel.pandian.seithigal.R
import com.samuvel.pandian.seithigal.hotnewsdetail.view.HotNewsDetailFragment

class HotNewsDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hot_news_detail)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.hot_news_detail_root_container, HotNewsDetailFragment.newInstance(), "hotNewsDetailFragment")
                .commit()
        }
    }
}
