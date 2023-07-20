package com.hninor.pruebamercadolibre.utils

import android.widget.ImageView

interface ImageLoader {
    fun displayImage(url: String?, imageView: ImageView)
}