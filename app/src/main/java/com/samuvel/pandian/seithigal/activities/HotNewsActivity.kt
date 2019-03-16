package com.samuvel.pandian.seithigal.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.samuvel.pandian.seithigal.R
import com.samuvel.pandian.seithigal.hotnews.view.HotNewsFragment

class HotNewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_root, HotNewsFragment.newInstance(), "hotNewsFragment")
                .commit()
        }
    }
}
