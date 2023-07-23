package com.hninor.pruebamercadolibre.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
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

    fun replaceFragment(fragment: Fragment, tag: String?) {
        //Get current fragment placed in container
        val currentFragment = supportFragmentManager.findFragmentById(R.id.container)

        //Prevent adding same fragment on top
        if (currentFragment != null && currentFragment.javaClass == fragment.javaClass) {
            return
        }

        //If fragment is already on stack, we can pop back stack to prevent stack infinite growth
        if (supportFragmentManager.findFragmentByTag(tag) != null) {
            supportFragmentManager.popBackStack(tag, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }

        //Otherwise, just replace fragment
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(tag)
            .replace(R.id.container, fragment, tag)
            .commit()
    }
}