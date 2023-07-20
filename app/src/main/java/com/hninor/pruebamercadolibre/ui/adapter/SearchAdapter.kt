package com.hninor.pruebamercadolibre.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hninor.pruebamercadolibre.databinding.LayoutSearchItemBinding
import com.hninor.pruebamercadolibre.repository.entities.Result

class SearchAdapter() :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var tweets: MutableList<Result>? = null
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
        return (tweets?.size ?: 0) + 1
    }


    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        (holder as? SearchViewHolder)?.bind(tweets!![position])

    }

    fun addMoreTweet(tweets: List<Result>?) {
        if (tweets.isNullOrEmpty() || this.tweets.isNullOrEmpty()) {
            return
        }
        val newTweetSize = tweets.size
        val oldTweetsSize = this.tweets!!.size
        this.tweets!!.addAll(tweets)
        notifyItemRangeInserted(oldTweetsSize + 1, newTweetSize)
    }

}