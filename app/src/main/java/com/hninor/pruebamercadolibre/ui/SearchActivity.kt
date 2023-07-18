package com.hninor.pruebamercadolibre.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hninor.pruebamercadolibre.R

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SearchFragment.newInstance())
                .commitNow()
        }
    }
}