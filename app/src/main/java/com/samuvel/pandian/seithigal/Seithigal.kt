package com.samuvel.pandian.seithigal

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

class Seithigal : Application() {
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}