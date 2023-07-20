package com.hninor.pruebamercadolibre

import android.app.Application
import com.hninor.pruebamercadolibre.utils.GlideImageLoader
import com.hninor.pruebamercadolibre.utils.ImageLoader

class MercadoLibreApplication : Application() {

    companion object {
        lateinit var app: Application
        lateinit var imageLoader: ImageLoader
    }

    override fun onCreate() {
        super.onCreate()
        app = this
        //ScreenAdaptiveUtil.adaptive(this)

        initImageLoader()
    }

    private fun initImageLoader() {
        imageLoader = GlideImageLoader(this)
    }
}
