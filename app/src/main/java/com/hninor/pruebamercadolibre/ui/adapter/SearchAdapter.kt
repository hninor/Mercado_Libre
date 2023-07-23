package com.hninor.pruebamercadolibre.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hninor.pruebamercadolibre.databinding.LayoutSearchItemBinding
import com.hninor.pruebamercadolibre.repository.entities.Result

class SearchAdapter() :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var results: MutableList<Result>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SearchViewHolder(
            LayoutSearchItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return (results?.size ?: 0)
    }


    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        (holder as? SearchViewHolder)?.bind(results!![position])

    }

    fun addMoreTweet(tweets: List<Result>?) {
        if (tweets.isNullOrEmpty() || this.results.isNullOrEmpty()) {
            return
        }
        val newTweetSize = tweets.size
        val oldTweetsSize = this.results!!.size
        this.results!!.addAll(tweets)
        notifyItemRangeInserted(oldTweetsSize + 1, newTweetSize)
    }

}